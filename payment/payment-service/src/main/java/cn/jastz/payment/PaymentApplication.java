package cn.jastz.payment;

import cn.jastz.payment.service.CustomUserInfoTokenServices;
import com.github.wxpay.sdk.WXPayConfig;
import me.jastz.common.wx.DefaultWXPayConfig;
import me.jastz.common.wx.WxTemplates;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

@EnableResourceServer
@EnableOAuth2Client
@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
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
