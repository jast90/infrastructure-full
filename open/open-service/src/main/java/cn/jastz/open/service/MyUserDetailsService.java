package cn.jastz.open.service;

import cn.jastz.common.entity.MyUser;
import cn.jastz.open.entity.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author zhiwen
 */
@Service
public class MyUserDetailsService implements UserDetailsService {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private AccountService accountService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //查询用户时如何区分各个业务的用户
        User app  = (User) authentication.getPrincipal();
        String appId = app.getUsername();
        Account account = accountService.selectAccountByAccountNameAndAppId(username,appId);
        if (account == null) {
            throw new UsernameNotFoundException(username);
        }
        // 这里的password需要传递过去，因为需要校验
        String password = "";
        if (account.getAccountPassword() != null) {
            password = account.getAccountPassword().getAccountPassword();
        }
        MyUser user = new MyUser(account.getAccountId(),account.getAccountId().toString(),password);
        return user;
    }
}
