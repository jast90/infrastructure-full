package cn.jastz.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;

/**
 * @author zhiwen
 */
@EnableFeignClients(basePackages = "cn.jastz.*.client")
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableConfigurationProperties
@ComponentScan(basePackages = {"cn.jastz.mall", "cn.jastz.common", "cn.jastz.social"})
public class MallApplication {


    public static void main(String[] args) {
        SpringApplication.run(MallApplication.class, args);
    }

    @Bean
    @ConfigurationProperties(prefix = "security.oauth2.client")
    public OAuth2ProtectedResourceDetails clientCredentialsResourceDetails() {
//        return new AuthorizationCodeResourceDetails();
        return new ClientCredentialsResourceDetails();
    }
}
