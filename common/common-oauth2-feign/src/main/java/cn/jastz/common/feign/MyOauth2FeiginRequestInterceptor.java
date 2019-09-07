package cn.jastz.common.feign;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;

public class MyOauth2FeiginRequestInterceptor implements RequestInterceptor {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    public void apply(RequestTemplate requestTemplate) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        logger.debug("authentication class:{}",authentication.getClass());
        if (authentication != null && authentication.getDetails() instanceof OAuth2AuthenticationDetails) {
            OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) authentication.getDetails();
            String token = details.getTokenValue();
            requestTemplate.header("Authorization",String.format("%s %s","Bearer",token));
        }

    }
}
