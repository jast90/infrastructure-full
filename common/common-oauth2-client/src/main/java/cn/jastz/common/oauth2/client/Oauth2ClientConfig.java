package cn.jastz.common.oauth2.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

/**
 * oauth2 client端的一个实例
 *
 * @author zhiwen
 */
@EnableOAuth2Client
@Configuration
//@EnableConfigurationProperties
public class Oauth2ClientConfig {
    @Autowired
    private Oauth2ClientProperties oauth2ClientProperties;

    @Primary
    @Bean("resourceOwnerPasswordResourceDetails")
    public ResourceOwnerPasswordResourceDetails resourceOwnerPasswordResourceDetails() {
        ResourceOwnerPasswordResourceDetails resourceOwnerPasswordResourceDetails = new ResourceOwnerPasswordResourceDetails();
        resourceOwnerPasswordResourceDetails.setClientId(oauth2ClientProperties.getClientId());
        resourceOwnerPasswordResourceDetails.setClientSecret(oauth2ClientProperties.getClientSecret());
        resourceOwnerPasswordResourceDetails.setScope(oauth2ClientProperties.getScope());
        resourceOwnerPasswordResourceDetails.setAccessTokenUri(oauth2ClientProperties.getAccessTokenUri());
        return resourceOwnerPasswordResourceDetails;
    }

    @Bean("clientCredentialsResourceDetails")
    public ClientCredentialsResourceDetails clientCredentialsResourceDetails() {
        ClientCredentialsResourceDetails clientCredentialsResourceDetails = new ClientCredentialsResourceDetails();
        clientCredentialsResourceDetails.setClientId(oauth2ClientProperties.getClientId());
        clientCredentialsResourceDetails.setClientSecret(oauth2ClientProperties.getClientSecret());
        clientCredentialsResourceDetails.setScope(oauth2ClientProperties.getScope());
        clientCredentialsResourceDetails.setAccessTokenUri(oauth2ClientProperties.getAccessTokenUri());
        return clientCredentialsResourceDetails;
    }
}
