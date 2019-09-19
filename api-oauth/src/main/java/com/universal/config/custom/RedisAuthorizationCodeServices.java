package com.universal.config.custom;

import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.common.exceptions.InvalidGrantException;
import org.springframework.security.oauth2.common.util.RandomValueStringGenerator;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.store.redis.JdkSerializationStrategy;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStoreSerializationStrategy;

public class RedisAuthorizationCodeServices implements AuthorizationCodeServices {
    private static final String ACCESS = "authorization_code:";
    private RedisConnectionFactory redisConnectionFactory;

    private RedisTokenStoreSerializationStrategy serializationStrategy = new JdkSerializationStrategy();

    public RedisAuthorizationCodeServices(RedisConnectionFactory redisConnectionFactory) {
        this.redisConnectionFactory = redisConnectionFactory;
    }

    private RandomValueStringGenerator generator = new RandomValueStringGenerator(12);

    private RedisConnection getConnection() {
        return redisConnectionFactory.getConnection();
    }

    protected void store(String code, OAuth2Authentication authentication) {
        byte[] serializedAuthentication = serializationStrategy.serialize(authentication);
        byte[] serializedKey = serializationStrategy.serialize(ACCESS + code);

        RedisConnection conn = getConnection();

        try {
            conn.openPipeline();
            conn.append(serializedKey, serializedAuthentication);
            conn.expire(serializedKey, 60);
            conn.closePipeline();
        } finally {
            conn.close();
        }

    }

    protected OAuth2Authentication remove(String code) {
        OAuth2Authentication authentication;

        RedisConnection conn = getConnection();
        byte[] serializedKey = serializationStrategy.serialize(ACCESS + code);
        byte[] buffer = null;
        try {
            buffer = conn.get(serializedKey);
        } finally {
            conn.close();
        }

        authentication = serializationStrategy.deserialize(buffer, OAuth2Authentication.class);
        if (authentication != null) {
            conn = getConnection();
            try {
                conn.openPipeline();
                conn.del(serializedKey);
                conn.closePipeline();
            } finally {
                conn.close();
            }
        }

        return authentication;
    }

    public String createAuthorizationCode(OAuth2Authentication authentication) {
        String code = generator.generate();
        store(code, authentication);
        return code;
    }

    public OAuth2Authentication consumeAuthorizationCode(String code) throws InvalidGrantException {
        OAuth2Authentication auth = this.remove(code);
        if (auth == null) {
            throw new InvalidGrantException("Invalid authorization code: " + code);
        }
        return auth;
    }

}

