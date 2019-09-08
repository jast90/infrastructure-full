package cn.jastz.cms.controller;

import cn.jastz.open.client.AccountClient;
import cn.jastz.open.entity.Account;
import me.jastz.common.json.result.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {


    @Autowired
    private AccountClient accountClient;

    @Autowired
    private OAuth2RestTemplate accountRestTemplate;

    @ResponseBody
    @GetMapping("user/{accountId}")
    public Account getUserById(@PathVariable("accountId") int accountId) {
        return accountClient.queryAccountByAccountId(accountId);
    }

    @ResponseBody
    @GetMapping("test2")
    public BaseResult testResult1() {
        return accountClient.testResult();
    }

    @ResponseBody
    @GetMapping("test")
    public BaseResult testResult() {
        return accountRestTemplate.getForEntity("http://localhost:8081/account/result", BaseResult.class).getBody();
    }
}
