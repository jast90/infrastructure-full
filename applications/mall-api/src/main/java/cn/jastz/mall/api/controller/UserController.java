package cn.jastz.mall.api.controller;


import cn.jastz.common.web.controller.CommonBaseController;
import cn.jastz.mall.api.form.UserSignUpForm;
import cn.jastz.mall.api.vo.UserRoleResourceVo;
import cn.jastz.open.client.AccountClient;
import cn.jastz.open.entity.Account;
import cn.jastz.open.entity.AccountPassword;
import cn.jastz.open.form.AccountAddForm;
import com.google.common.collect.Lists;
import me.jastz.common.json.JsonUtil;
import me.jastz.common.json.result.BaseResult;
import me.jastz.common.json.result.IResult;
import me.jastz.common.json.result.SampleResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhiwen
 */
@RestController
public class UserController extends CommonBaseController {

    @Autowired
    private AccountClient accountClient;


    @GetMapping("user")
    public List<Account> user() {
        int accountId = Integer.parseInt(SecurityContextHolder.getContext().getAuthentication().getName());
        Account account = accountClient.queryAccountByAccountId(accountId);
        System.out.println("account:" + JsonUtil.objectToPrettyJson(account));
        return Lists.newArrayList(account);
    }

    @GetMapping("/ignore/hello")
    public List<String> hello() {
        return Lists.newArrayList("hello");
    }

    @GetMapping("/ignore/exception")
    public List<String> exception() {
        throw new RuntimeException();
    }

    @PostMapping("signUp")
    public BaseResult signUp(@RequestBody UserSignUpForm userSignUpForm){
        AccountAddForm accountAddForm = new AccountAddForm();
        Account account = new Account();
        account.setAccountName(userSignUpForm.getUsername());
        account.setAccountPassword(new AccountPassword(userSignUpForm.getPassword()));
        accountAddForm.setAccount(account);
        BaseResult baseResult = accountClient.addAccount(accountAddForm);
        return baseResult;
    }
}
