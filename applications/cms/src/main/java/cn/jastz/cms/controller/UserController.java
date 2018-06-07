package cn.jastz.cms.controller;

import cn.jastz.account.client.AccountClient;
import cn.jastz.account.client.LoginClient;
import cn.jastz.account.entity.Account;
import me.jastz.common.json.result.IResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    private LoginClient loginClient;

    @Autowired
    private AccountClient accountClient;

    @GetMapping("/")
    public String login() {
        return "index";
    }


    @ResponseBody
    @GetMapping("user/{accountId}")
    public Account getUserById(@PathVariable("accountId") int accountId) {
        return accountClient.queryAccountByAccountId(accountId);
    }

    @ResponseBody
    @GetMapping("test")
    public IResult testResult() {
        return accountClient.testResult();
    }
}
