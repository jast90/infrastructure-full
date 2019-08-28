package cn.jastz.mall.api;

import me.jastz.swagger.spring.boot.autoconfig.EnableSwagger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author zhiwen
 */
@EnableFeignClients(basePackages = "cn.jastz.*.client")
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class}, scanBasePackages = {"cn.jastz.common", "cn.jastz.mall.api"})
@EnableSwagger
@EnableDiscoveryClient
public class MallApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallApiApplication.class, args);
    }

}
