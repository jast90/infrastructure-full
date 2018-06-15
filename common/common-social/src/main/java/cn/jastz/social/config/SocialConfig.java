package cn.jastz.social.config;

import cn.jastz.social.MyConnectionSignUp;
import cn.jastz.social.MySignInAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.mem.InMemoryUsersConnectionRepository;
import org.springframework.social.connect.web.SignInAdapter;

/**
 * @author zhiwen
 */
@Configuration
public class SocialConfig extends SocialConfigurerAdapter {
    @Autowired
    private ConnectionSignUp connectionSignUp;

    @Override
    public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
        System.out.println("usersConnectionRepository init");
        InMemoryUsersConnectionRepository inMemoryUsersConnectionRepository = new InMemoryUsersConnectionRepository(connectionFactoryLocator);
        inMemoryUsersConnectionRepository.setConnectionSignUp(connectionSignUp);
        return inMemoryUsersConnectionRepository;
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
