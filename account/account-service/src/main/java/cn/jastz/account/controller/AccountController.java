package cn.jastz.account.controller;

import cn.jastz.account.entity.Account;
import cn.jastz.account.form.AccountAddForm;
import cn.jastz.account.result.AccountResult;
import cn.jastz.account.service.AccountService;
import cn.jastz.common.controller.CommonBaseController;
import me.jastz.common.json.result.IResult;
import me.jastz.common.json.result.SampleResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zhiwen
 */
@RequestMapping("account")
@Controller
public class AccountController extends CommonBaseController {
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private AccountService accountService;

    @GetMapping("logout")
    public String logout() {
        request.getSession().invalidate();
        return "redirect:/";
    }

    @ResponseBody
    @GetMapping("result")
    public IResult testResult() {
        logger.debug("Current app id is {}", getAppId());
        return SampleResult.FAIL;
    }

    @ResponseBody
    @GetMapping("/{id}")
    public Account queryAccountByAccountId(@PathVariable("id") int accountId) {
        return accountService.queryByAccountId(accountId);
    }

    @ResponseBody
    @GetMapping("queryAccountByUsernameAndSocial/{username}/{social}")
    public Account queryAccountByUsernameAndSocial(@PathVariable("username") String username, @PathVariable("social") String social) {
        return accountService.selectAccountByUsernameAndSocial(username, social);
    }

    @ResponseBody
    @PostMapping("add")
    public IResult addAccount(@RequestBody AccountAddForm accountAddForm) {
        int count = accountService.saveAccount(accountAddForm.getAccount(), accountAddForm.getAccountSocialRef());
        if (count > 0) {
            return AccountResult.SUCCESS;
        }
        return AccountResult.FAIL;
    }


}
