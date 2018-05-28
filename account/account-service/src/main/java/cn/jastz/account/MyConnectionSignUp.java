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
        System.out.println(connection.getKey().getProviderId());
        UserProfile userProfile = connection.fetchUserProfile();
        Account account = new Account();
        account.setAccountName(userProfile.getName());
        account.setFirstName(userProfile.getFirstName());
        account.setLastName(userProfile.getLastName());
        account.setEmail(userProfile.getEmail());
        account.setUsername(userProfile.getUsername());
        account.setAcountFrom(connection.getKey().getProviderId());
        int i = accountMapper.insert(account);
        //TODO 用户存在时，查询出用户。
        if(i>0){
            return String.valueOf(account.getAccountId());
        }else{
            return null;
        }
    }
}
