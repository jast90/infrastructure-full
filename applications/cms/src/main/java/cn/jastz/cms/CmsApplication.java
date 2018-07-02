package cn.jastz.cms;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import feign.RequestInterceptor;
import me.jastz.common.aliyun.oss.AliYunOssTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.security.oauth2.client.feign.OAuth2FeignRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;

/**
 * @author zhiwen
 */
@EnableFeignClients(basePackages = "cn.jastz.*.client")
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableConfigurationProperties
@ComponentScan(basePackages = {"cn.jastz.cms", "cn.jastz.social"})
public class CmsApplication {

    public static final String ossEndpoint = "oss-cn-beijing.aliyuncs.com";

    public static void main(String[] args) {
        SpringApplication.run(CmsApplication.class, args);
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
    public OAuth2ProtectedResourceDetails clientCredentialsResourceDetails() {
//        return new AuthorizationCodeResourceDetails();
        return new ClientCredentialsResourceDetails();
    }

    @Bean
    public OSS oss() {
        OSS oss = new OSSClientBuilder().build(ossEndpoint, "", "");
        return oss;
    }

    @Bean
    public AliYunOssTemplate aliYunOssTemplate(OSS oss) {
        return new AliYunOssTemplate(oss);
    }
}
