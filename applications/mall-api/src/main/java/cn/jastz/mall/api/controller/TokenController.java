package cn.jastz.mall.api.controller;

import cn.jastz.mall.api.form.UserForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhiwen
 */
@RestController
public class TokenController {
    private final Logger log = LoggerFactory.getLogger(getClass());
    @Resource(name = "resourceOwnerPasswordResourceDetails")
    private ResourceOwnerPasswordResourceDetails resourceOwnerPasswordResourceDetails;

    @PostMapping("token")
    public OAuth2AccessToken hello(@RequestBody UserForm userForm) {
        OAuth2RestTemplate oAuth2RestTemplate = new OAuth2RestTemplate(resourceOwnerPasswordResourceDetails);
        oAuth2RestTemplate.getOAuth2ClientContext().getAccessTokenRequest().set("username", userForm.getUsername());
        oAuth2RestTemplate.getOAuth2ClientContext().getAccessTokenRequest().set("password", userForm.getPassword());
        try {
            OAuth2AccessToken auth2AccessToken = oAuth2RestTemplate.getAccessToken();
            return auth2AccessToken;

        } catch (Exception e) {
            log.error("user login error", e);
            throw new RuntimeException(e);
        }

    }
}
