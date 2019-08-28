package cn.jastz.oss;


import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import me.jastz.common.aliyun.oss.AliYunOssTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
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
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
@Configuration
@ComponentScan(basePackages = {"cn.jastz"})
public class OssServiceApplication extends SpringBootServletInitializer {
    public static final String ossEndpoint = "oss-cn-beijing.aliyuncs.com";

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(OssServiceApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(OssServiceApplication.class, args);
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

