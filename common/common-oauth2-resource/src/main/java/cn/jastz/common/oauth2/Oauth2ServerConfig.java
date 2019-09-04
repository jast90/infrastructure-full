package cn.jastz.common.oauth2;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhiwen
 */
@Configuration
@ConfigurationProperties(prefix = "oauth2.server")
public class Oauth2ServerConfig {
    private String host = "localhost";

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
}
