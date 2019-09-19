package com.universal.config;

import com.universal.config.exception.CustomAccessDeniedHandler;
import com.universal.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.DefaultOAuth2ExceptionRenderer;
import org.springframework.security.oauth2.provider.error.OAuth2AuthenticationEntryPoint;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Response;

/**
 * 资源访问配置类
 * @author YIJIUE
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    @Autowired
    private CustomAccessDeniedHandler customAccessDeniedHandler;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.requestMatcher(new OAuth2RequestedMatcher()).authorizeRequests()
                .antMatchers("/oauth/token").permitAll() // 放开权限的url
                .anyRequest().authenticated();
    }

    /**
     * 判断来源请求是否包含oauth2授权信息<br>
     * url参数中含有access_token,或者header里有Authorization
     */
    private static class OAuth2RequestedMatcher implements RequestMatcher {
        @Override
        public boolean matches(HttpServletRequest request) {
            if (request.getParameter(OAuth2AccessToken.ACCESS_TOKEN) != null) {
                return true;
            }
            String auth = request.getHeader("Authorization");
            if (auth != null) {
                return auth.startsWith(OAuth2AccessToken.BEARER_TYPE);
            }
            return false;
        }
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        OAuth2AuthenticationEntryPoint authenticationEntryPoint = new OAuth2AuthenticationEntryPoint();
        authenticationEntryPoint.setExceptionRenderer(new DefaultOAuth2ExceptionRenderer() {
            @Override
            public void handleHttpEntityResponse(HttpEntity<?> responseEntity, ServletWebRequest webRequest)
                    throws Exception {
                if (responseEntity == null) {
                    return;
                }
                if (responseEntity.hasBody() && responseEntity.getBody() instanceof OAuth2Exception) {
                    OAuth2Exception exception = (OAuth2Exception) responseEntity.getBody();
                    ResponseVo<Void> response = new ResponseVo<>(5,
                            exception.getMessage());
                    responseEntity = new HttpEntity<>(response);
                }
                super.handleHttpEntityResponse(responseEntity, webRequest);
            }
        });
        resources.stateless(true).authenticationEntryPoint(authenticationEntryPoint).accessDeniedHandler(customAccessDeniedHandler);
    }

}
