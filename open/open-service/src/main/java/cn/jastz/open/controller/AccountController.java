package cn.jastz.open.controller;

import cn.jastz.common.controller.CommonBaseController;
import cn.jastz.open.entity.Account;
import cn.jastz.open.entity.AccountSocialRef;
import cn.jastz.open.form.AccountAddForm;
import cn.jastz.open.result.OpenResult;
import cn.jastz.open.service.AccountService;
import me.jastz.common.json.JsonUtil;
import me.jastz.common.json.result.IResult;
import me.jastz.common.json.result.SampleResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhiwen
 */
@RequestMapping("account")
@RestController
public class AccountController extends CommonBaseController {
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private AccountService accountService;

    @GetMapping("result")
    public IResult testResult() {
        logger.debug("Current app id is {}", getAppId());
        logger.debug("Current authentication is {}", JsonUtil.objectToPrettyJson(getAuthentication()));
        return SampleResult.FAIL;
    }

    @GetMapping("/{id}")
    public Account queryAccountByAccountId(@PathVariable("id") int accountId) {
        return accountService.queryByAccountId(accountId);
    }

    @GetMapping("queryAccountByUsernameAndSocial/{username}/{social}")
    public Account queryAccountByUsernameAndSocial(@PathVariable("username") String username, @PathVariable("social") String social) {
        return accountService.selectAccountByUsernameAndSocialAndAppId(username, social, getAppId());
    }

    @GetMapping("queryAccountByUsernameAndAppId/{username}")
    public Account queryAccountByUsernameAndAppId(@PathVariable("username") String username) {
        return accountService.selectAccountByUsernameAndAppId(username, getAppId());
    }

    @PostMapping("add")
    public IResult addAccount(@RequestBody AccountAddForm accountAddForm) {
        accountAddForm.getAccount().setAppId(getAppId());
        accountAddForm.getAccountSocialRef().setAppId(getAppId());
        int count = accountService.saveAccount(accountAddForm.getAccount(), accountAddForm.getAccountSocialRef(), accountAddForm.getPassword());
        if (count > 0) {
            return OpenResult.SUCCESS;
        }
        return OpenResult.FAIL;
    }

    @PostMapping("addAccountSocialRef")
    public IResult addAccountSocialRef(AccountSocialRef accountSocialRef) {
        if (accountService.saveAccountSocialRef(accountSocialRef) > 0) {
            return OpenResult.SUCCESS;
        }
        return OpenResult.FAIL;
    }


}
