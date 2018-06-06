package cn.jastz.payment.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * @author zhiwen
 */
@Configuration
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    public ResourceServerConfig() {
        System.out.println("ResourceServerConfig init");
    }
}
