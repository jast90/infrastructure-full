package cn.jastz.open.service;

import cn.jastz.account.client.AccountClient;
import cn.jastz.account.entity.Account;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private AccountClient accountClient;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountClient.queryAccountByUsernameAndSocial(username, "");
        if (account == null) {
            throw new UsernameNotFoundException(username);
        }
        //TODO 这里的password需要传递过去，因为需要校验
        User user = new User(account.getAccountName(), "123", Lists.newArrayList());
        return user;
    }
}
