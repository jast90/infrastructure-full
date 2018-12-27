package cn.jastz.common.feign;

import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.security.oauth2.client.feign.OAuth2FeignRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;

/**
 * @author zhiwen
 */
@Configuration
public class FeignConfig {

    @Bean
    public RequestInterceptor oauth2FeignRequestInterceptor(@Autowired OAuth2ProtectedResourceDetails clientCredentialsResourceDetails) {
        return new OAuth2FeignRequestInterceptor(new DefaultOAuth2ClientContext(), clientCredentialsResourceDetails);
    }

    @Bean
    public OAuth2RestTemplate clientCredentialsRestTemplate(@Autowired OAuth2ProtectedResourceDetails clientCredentialsResourceDetails) {
        return new OAuth2RestTemplate(clientCredentialsResourceDetails);
    }

}
