package cn.jastz.common.feign;

import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.security.oauth2.client.feign.OAuth2FeignRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;

/**
 * 需要配置feign oauth2 client 配置信息
 *
 * @author zhiwen
 */
@Configuration
//@EnableConfigurationProperties
public class FeignConfig {

    @Bean
    public RequestInterceptor oauth2FeignRequestInterceptor() {
        return new MyOauth2FeiginRequestInterceptor();
    }

}
