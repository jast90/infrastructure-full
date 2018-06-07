package cn.jastz.account.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zhiwen
 */
@FeignClient("account")
public interface LoginClient {

    @GetMapping("login/{social}")
    String login(@PathVariable("social") String social);
}
