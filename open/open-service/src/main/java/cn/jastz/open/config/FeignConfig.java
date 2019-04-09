package cn.jastz.open.config;

import cn.jastz.account.client.AccountClient;
import cn.jastz.account.entity.Account;
import cn.jastz.open.entity.App;
import cn.jastz.open.mapper.AppMapper;
import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.security.oauth2.client.feign.OAuth2FeignRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;

/**
 * 需要配置feign oauth2 client 配置信息
 *
 * @author zhiwen
 */
@Configuration
//@EnableConfigurationProperties
public class FeignConfig {

    @Autowired
    private AccountClient accountClient;

    @Autowired
    private AppMapper appMapper;

    @Bean
    @ConfigurationProperties(prefix = "security.oauth2.client.feign")
    public OAuth2ProtectedResourceDetails clientCredentialsResourceDetails() {
//        return new AuthorizationCodeResourceDetails();
        App app = null;
        try {
            int accountId = Integer.parseInt(SecurityContextHolder.getContext().getAuthentication().getName());
            Account account = accountClient.queryAccountByAccountId(accountId);
            if (account != null) {
                app = appMapper.selectByPrimaryKey(account.getAppId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //TODO 能否根据调用方查询相关的appId和secret
        ClientCredentialsResourceDetails clientCredentialsResourceDetails = new ClientCredentialsResourceDetails();
        if (app != null) {
            clientCredentialsResourceDetails.setClientId(app.getAppId());
            clientCredentialsResourceDetails.setClientSecret(app.getAppSecret());
        }
        return clientCredentialsResourceDetails;
    }

    @Bean
    public RequestInterceptor oauth2FeignRequestInterceptor() {
        return new OAuth2FeignRequestInterceptor(new DefaultOAuth2ClientContext(), clientCredentialsResourceDetails());
    }

    @Bean
    public OAuth2RestTemplate clientCredentialsRestTemplate(@Autowired OAuth2ProtectedResourceDetails clientCredentialsResourceDetails) {
        return new OAuth2RestTemplate(clientCredentialsResourceDetails);
    }

}
