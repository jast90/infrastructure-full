package cn.jastz.payment;

import cn.jastz.payment.service.CustomUserInfoTokenServices;
import com.github.wxpay.sdk.WXPayConfig;
import feign.RequestInterceptor;
import me.jastz.common.wx.DefaultWXPayConfig;
import me.jastz.common.wx.WxTemplates;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.security.oauth2.client.feign.OAuth2FeignRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;


@EnableFeignClients(basePackages = "cn.jastz.*.client")
@EnableDiscoveryClient
@EnableOAuth2Client
@SpringBootApplication
@EnableConfigurationProperties
@MapperScan(basePackages = "cn.jastz.*.mapper")
@Configuration
public class PaymentApplication {
    @Autowired
    private ResourceServerProperties sso;

    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication.class, args);
    }

    @Bean
    public WxTemplates wxTemplates(WXPayConfig wxPayConfig) {
        return new WxTemplates(wxPayConfig);
    }

    @Bean
    public WXPayConfig wxPayConfig() {
        DefaultWXPayConfig wxPayConfig = new DefaultWXPayConfig();
        return wxPayConfig;
    }

    @Bean
    public RequestInterceptor oauth2FeignRequestInterceptor() {
        return new OAuth2FeignRequestInterceptor(new DefaultOAuth2ClientContext(), clientCredentialsResourceDetails());
    }

    @Bean
    public OAuth2RestTemplate clientCredentialsRestTemplate() {
        return new OAuth2RestTemplate(clientCredentialsResourceDetails());
    }

    @Bean
    @ConfigurationProperties(prefix = "security.oauth2.client")
    public ClientCredentialsResourceDetails clientCredentialsResourceDetails() {
        return new ClientCredentialsResourceDetails();
    }

    @Bean
    public ResourceServerTokenServices tokenServices() {
        return new CustomUserInfoTokenServices(sso.getUserInfoUri(), sso.getClientId());
    }
}
