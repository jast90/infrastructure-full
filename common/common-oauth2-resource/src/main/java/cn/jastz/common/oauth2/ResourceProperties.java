package cn.jastz.common.oauth2;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhiwen
 */
@Configuration
@ConfigurationProperties(prefix = "oauth2.resource")
public class ResourceProperties {
    private String clientId = "service";
    private String secret = "123456";

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }
}
