package cn.jastz.open;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

import java.util.Locale;

/**
 * 为了将项目打包成war包需要继承自SpringBootServletInitializer
 *
 * @author jast
 */
@SpringBootApplication
@MapperScan(basePackages = "cn.jastz.*.mapper")
public class OpenServiceApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {

        return application.sources(OpenServiceApplication.class);
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        SpringApplication.run(OpenServiceApplication.class, args);
    }

}
