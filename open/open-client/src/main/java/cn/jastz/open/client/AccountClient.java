package cn.jastz.open.client;

import cn.jastz.open.entity.Account;
import cn.jastz.open.form.AccountAddForm;
import me.jastz.common.json.result.BaseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author zhiwen
 */
@FeignClient("open")
public interface AccountClient {
    @GetMapping("account/{id}")
    Account queryAccountByAccountId(@PathVariable("id") int accountId);

    @GetMapping("account/result")
    BaseResult testResult();

    @PostMapping("account/add")
    BaseResult addAccount(@RequestBody AccountAddForm accountAddForm);

    @GetMapping("account/queryAccountByUsernameAndSocial/{username}/{social}")
    Account queryAccountByUsernameAndSocial(@PathVariable("username") String username, @PathVariable("social") String social);

    @GetMapping("account/queryAccountByUsernameAndAppId/{username}")
    Account queryAccountByUsernameAndAppId(@PathVariable("username") String username);
}
