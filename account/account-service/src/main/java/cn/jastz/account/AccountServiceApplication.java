package cn.jastz.account;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.mem.InMemoryUsersConnectionRepository;
import org.springframework.social.connect.web.SignInAdapter;

import javax.sql.DataSource;

@SpringBootApplication
@MapperScan(basePackages = "cn.jastz.*.mapper")
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class,args);
    }

    @Bean
    public SignInAdapter signInAdapter(){
        return new MySignInAdapter();
    }

    @Bean
    public UsersConnectionRepository usersConnectionRepository(DataSource dataSource, ConnectionFactoryLocator factoryLocator
            , ConnectionSignUp connectionSignUp){
        /*JdbcUsersConnectionRepository jdbcUsersConnectionRepository = new JdbcUsersConnectionRepository(dataSource,
                factoryLocator,Encryptors.noOpText());*/

        InMemoryUsersConnectionRepository inMemoryUsersConnectionRepository = new InMemoryUsersConnectionRepository(factoryLocator);
        inMemoryUsersConnectionRepository.setConnectionSignUp(connectionSignUp);
        return inMemoryUsersConnectionRepository;
    }

    @Bean
    public ConnectionSignUp connectionSignUp(){
        return new MyConnectionSignUp();
    }




}
