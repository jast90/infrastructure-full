package cn.jastz.account;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.web.SignInAdapter;

@SpringBootApplication
@MapperScan(basePackages = "cn.jastz.*.mapper")
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class,args);
    }

    @Bean
    public SignInAdapter signInAdapter(){
        System.out.println("signInAdapter init");
        return new MySignInAdapter();
    }


    @Bean
    public ConnectionSignUp connectionSignUp(){
        return new MyConnectionSignUp();
    }




}
