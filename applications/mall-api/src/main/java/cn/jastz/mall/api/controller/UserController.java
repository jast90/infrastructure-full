package cn.jastz.mall.api.controller;


import cn.jastz.common.web.controller.CommonBaseController;
import cn.jastz.mall.api.vo.UserRoleResourceVo;
import cn.jastz.open.client.AccountClient;
import cn.jastz.open.entity.Account;
import com.google.common.collect.Lists;
import me.jastz.common.json.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
