package cn.jastz.mall.api.controller;

import cn.jastz.account.client.AccountClient;
import cn.jastz.account.entity.Account;
import cn.jastz.common.entity.MyUser;
import cn.jastz.common.web.controller.CommonBaseController;
import cn.jastz.mall.api.vo.UserRoleResourceVo;
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
    public List<UserRoleResourceVo> user() {
        int accountId = Integer.parseInt(SecurityContextHolder.getContext().getAuthentication().getName());
        Account account = accountClient.queryAccountByAccountId(accountId);
        System.out.println("account:" + JsonUtil.objectToPrettyJson(account));
        return Lists.newArrayList();
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
