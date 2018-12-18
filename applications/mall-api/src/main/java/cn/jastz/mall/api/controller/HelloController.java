package cn.jastz.mall.api.controller;

import cn.jastz.mall.api.form.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhiwen
 */
@RestController
public class HelloController {
    @Autowired
    private OAuth2RestTemplate restTemplate;

    @PostMapping("token")
    public OAuth2AccessToken hello(@RequestBody UserForm userForm) {
        restTemplate.getOAuth2ClientContext().getAccessTokenRequest().set("username", userForm.getUsername());
        restTemplate.getOAuth2ClientContext().getAccessTokenRequest().set("password", userForm.getPassword());
        return restTemplate.getAccessToken();
    }

    @GetMapping("hello")
    public String hello() {
        return "Hello";
    }
}
