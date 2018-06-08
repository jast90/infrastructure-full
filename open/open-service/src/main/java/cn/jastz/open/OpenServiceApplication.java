package cn.jastz.open;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * 为了将项目打包成war包需要继承自SpringBootServletInitializer
 *
 * @author jast
 */
@EnableFeignClients(basePackages = "cn.jastz.*.client")
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
@SpringBootApplication
@MapperScan(basePackages = "cn.jastz.*.mapper")
@EnableDiscoveryClient
public class OpenServiceApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {

        return application.sources(OpenServiceApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(OpenServiceApplication.class, args);
    }

}
