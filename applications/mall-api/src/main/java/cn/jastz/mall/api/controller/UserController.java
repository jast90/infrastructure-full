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
        int accountId = 0;
        String username;
        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof MyUser) {
            MyUser myUser = (MyUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            accountId = myUser.getUserId();
            username = myUser.getUsername();
        } else {
            username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        }
        //TODO 根据appId和username查询用户信息（：角色、资源）
        System.out.println("username:" + username);
        Account account = accountClient.queryAccountByAccountId(accountId);
        System.out.println("account:" + JsonUtil.objectToPrettyJson(account));
        return Lists.newArrayList();
    }
}
