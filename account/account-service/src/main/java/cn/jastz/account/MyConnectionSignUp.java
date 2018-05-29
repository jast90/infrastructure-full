package cn.jastz.account;

import cn.jastz.account.entity.Account;
import cn.jastz.account.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UserProfile;

public class MyConnectionSignUp implements ConnectionSignUp {

    @Autowired
    private AccountMapper accountMapper;

    public MyConnectionSignUp() {
        System.out.println("MyConnectionSignUp init");
    }

    @Override
    public String execute(Connection<?> connection) {
        UserProfile userProfile = connection.fetchUserProfile();
        Account account1 = accountMapper.selectByUsernameAndAccountFrom(userProfile.getUsername(), connection.getKey().getProviderId());
        if (account1 == null) {
            Account account = new Account();
            account.setAccountName(userProfile.getName());
            account.setFirstName(userProfile.getFirstName());
            account.setLastName(userProfile.getLastName());
            account.setEmail(userProfile.getEmail());
            account.setUsername(userProfile.getUsername());
            account.setAccountFrom(connection.getKey().getProviderId());
            int i = accountMapper.insert(account);

            if (i > 0) {
                return String.valueOf(account.getAccountId());
            } else {
                return null;
            }
        } else {
            return String.valueOf(account1.getAccountId());
        }

    }
}
