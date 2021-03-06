package cn.jastz.open.config;

import cn.jastz.open.service.MyClientDetailsService;
import cn.jastz.open.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * @author jast
 */
@Configuration
@EnableAuthorizationServer
public class OAuth2AuthorizationConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private MyClientDetailsService myClientDetailsService;

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private RedisConnectionFactory connectionFactory;

    /**
     * 如果要使用password grant type的话需要配置AuthenticationManager
     * 参考：https://stackoverflow.com/questions/28254519/spring-oauth2-authorization-server
     */
    @Autowired
    private AuthenticationManager authenticationManager;

    @Bean
    public TokenStore tokenStore() {
        RedisTokenStore tokenStore = new RedisTokenStore(connectionFactory);
//        TokenStore tokenStore = new InMemoryTokenStore();
        return tokenStore;
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(myClientDetailsService).build();
        /*clients.inMemory().withClient("clientId").secret("123456").and()
                .withClient("service").secret("123456")
                .authorizedGrantTypes("client_credentials", "refresh_token") .authorities("ROLE_CLIENT")
                .scopes("read", "trust");*/
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security
                .tokenKeyAccess("permitAll()")
                .checkTokenAccess("permitAll()")
                .allowFormAuthenticationForClients();
//        security./*tokenKeyAccess("isAnonymous() || hasAuthority('ROLE_CLIENT')").*/checkTokenAccess("permitAll()");
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(tokenStore()).userDetailsService(myUserDetailsService)
                .authenticationManager(authenticationManager);
    }
}
