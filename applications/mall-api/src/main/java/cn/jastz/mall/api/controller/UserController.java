package cn.jastz.mall.api.controller;

import cn.jastz.mall.api.vo.UserRoleResourceVo;
import com.google.common.collect.Lists;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhiwen
 */
@RestController
public class UserController {
    @GetMapping("user")
    public List<UserRoleResourceVo> user() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        //TODO 根据appId和username查询用户信息（：角色、资源）
        return Lists.newArrayList();
    }
}
