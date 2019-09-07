package cn.jastz.mall.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author zhiwen
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {




    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().and().csrf().disable();
    }


    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers(("/signUp,/favicon.ico,/token,/swagger-ui.html,/swagger-ui.html,/swagger-resources/configuration/ui" +
                        ", /swagger-resources, /swagger-resources/configuration/security,/webjars/**,/v2/api-docs,/api,/ignore/**").split(","));

    }
}
