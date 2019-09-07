package cn.jastz.common.feign;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;

import javax.annotation.Resource;

public class MyOauth2FeiginRequestInterceptor implements RequestInterceptor {

    @Resource(name = "clientCredentialsResourceDetails")
    private ClientCredentialsResourceDetails clientCredentialsResourceDetails;

    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    public void apply(RequestTemplate requestTemplate) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getDetails() instanceof OAuth2AuthenticationDetails) {
            logger.debug("authentication class:{}",authentication.getClass());
            OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) authentication.getDetails();
            String token = details.getTokenValue();
            requestTemplate.header("Authorization",String.format("%s %s","Bearer",token));
        }else{
            OAuth2RestTemplate oAuth2RestTemplate = new OAuth2RestTemplate(clientCredentialsResourceDetails);
            String token = oAuth2RestTemplate.getAccessToken().getValue();;
            requestTemplate.header("Authorization",String.format("%s %s","Bearer",token));
        }

    }
}
