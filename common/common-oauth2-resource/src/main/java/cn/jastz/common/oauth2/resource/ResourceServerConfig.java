package cn.jastz.common.oauth2.resource;

import cn.jastz.common.oauth2.Oauth2ServerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

@EnableResourceServer
@Configuration
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private Oauth2ServerConfig oauth2ServerConfig;

    @Primary
    @Bean
    @RefreshScope
    public ResourceServerTokenServices tokenServices() {
        RemoteTokenServices tokenServices = new RemoteTokenServices();
        tokenServices.setClientId("service");
        tokenServices.setClientSecret("service123");
        //TODO 将该地址放到配置文件
        tokenServices.setCheckTokenEndpointUrl(String.format("http://%s/oauth/check_token", oauth2ServerConfig.getHost()));
        return tokenServices;
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenServices(tokenServices());
    }
}
