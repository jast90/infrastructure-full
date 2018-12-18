package cn.jastz.open.service;

import cn.jastz.account.client.AccountClient;
import cn.jastz.account.entity.Account;
import com.google.common.collect.Lists;
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
    private AccountClient accountClient;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String appId = authentication.getName();
        logger.debug("client id :{}", appId);
        //查询用户时如何区分各个业务的用户
        Account account = accountClient.queryAccountByUsernameAndAppId(username, appId);
        if (account == null) {
            throw new UsernameNotFoundException(username);
        }
        // 这里的password需要传递过去，因为需要校验
        String password = "";
        if (account.getAccountPassword() != null) {
            password = account.getAccountPassword().getAccountPassword();
        }
        User user = new User(account.getAccountName(), password, Lists.newArrayList());
        return user;
    }
}
