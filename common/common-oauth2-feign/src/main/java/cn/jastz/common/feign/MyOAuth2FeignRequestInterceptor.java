package cn.jastz.common.feign;

import org.springframework.cloud.security.oauth2.client.feign.OAuth2FeignRequestInterceptor;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;

/**
 * @author zhiwen
 */
public class MyOAuth2FeignRequestInterceptor extends OAuth2FeignRequestInterceptor {


    public MyOAuth2FeignRequestInterceptor(OAuth2ClientContext oAuth2ClientContext, OAuth2ProtectedResourceDetails resource) {
        super(oAuth2ClientContext, resource);
    }

    public MyOAuth2FeignRequestInterceptor(OAuth2ClientContext oAuth2ClientContext, OAuth2ProtectedResourceDetails resource, String tokenType, String header) {
        super(oAuth2ClientContext, resource, tokenType, header);
    }
}
