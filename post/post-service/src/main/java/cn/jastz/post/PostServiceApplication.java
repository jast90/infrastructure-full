package cn.jastz.post;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;


/**
 * 为了将项目打包成war包需要继承自SpringBootServletInitializer
 *
 * @author jast
 */
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
@SpringBootApplication(exclude = {RedisAutoConfiguration.class})
@MapperScan(basePackages = "cn.jastz.*.mapper")
@EnableDiscoveryClient
@Configuration
@ComponentScan(basePackages = {"cn.jastz"})
public class PostServiceApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(PostServiceApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(PostServiceApplication.class, args);
    }

}

