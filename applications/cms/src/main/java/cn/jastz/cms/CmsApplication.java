package cn.jastz.cms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

/**
 * @author zhiwen
 */
@EnableFeignClients(basePackages = "cn.jastz.*.client")
@EnableOAuth2Client
@SpringBootApplication
public class CmsApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {

        return application.sources(CmsApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(CmsApplication.class, args);
    }

}
