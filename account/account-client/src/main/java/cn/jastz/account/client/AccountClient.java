package cn.jastz.account.client;

import cn.jastz.account.entity.Account;
import cn.jastz.account.form.AccountAddForm;
import me.jastz.common.json.result.BaseResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author zhiwen
 */
@FeignClient("account")
public interface AccountClient {
    @GetMapping("account/{id}")
    Account queryAccountByAccountId(@PathVariable("id") int accountId);

    @GetMapping("account/result")
    BaseResult testResult();

    @PostMapping("account/add")
    BaseResult addAccount(@RequestBody AccountAddForm accountAddForm);

    @GetMapping("account/queryAccountByUsernameAndSocial/{username}/{social}")
    Account queryAccountByUsernameAndSocial(@PathVariable("username") String username, @PathVariable("social") String social);

    @GetMapping("account/queryAccountByUsernameAndAppId/{username}/{appId}")
    Account queryAccountByUsernameAndAppId(@PathVariable("username") String username, @PathVariable("appId") String appId);
}
