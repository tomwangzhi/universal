package com.universal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * security 在spring5 以后更改了加密方式
 * 该方式为 hash算法 与加密算法不同
 * @author YIJIUE
 */
@Configuration
public class PassEncryptionConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
