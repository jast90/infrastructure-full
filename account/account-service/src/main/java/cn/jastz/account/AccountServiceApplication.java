package cn.jastz.account;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.web.SignInAdapter;

import java.util.Locale;

/**
 * 为了将项目打包成war包需要继承自SpringBootServletInitializer
 *
 * @author jast
 */

@SpringBootApplication
@MapperScan(basePackages = "cn.jastz.*.mapper")
public class AccountServiceApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {

        return application.sources(AccountServiceApplication.class);
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        SpringApplication.run(AccountServiceApplication.class, args);
    }

    @Bean
    public SignInAdapter signInAdapter() {
        System.out.println("signInAdapter init");
        return new MySignInAdapter();
    }


    @Bean
    public ConnectionSignUp connectionSignUp() {
        return new MyConnectionSignUp();
    }
}
