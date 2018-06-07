package cn.jastz.account.service;

import cn.jastz.account.entity.Account;
import cn.jastz.account.entity.AccountSocialRef;
import cn.jastz.account.mapper.AccountMapper;
import cn.jastz.account.mapper.AccountSocialRefMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhiwen
 */
@Service
public class AccountService {
    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private AccountSocialRefMapper accountSocialRefMapper;


    public Account selectAccountByUsernameAndSocial(String username, String social) {
        AccountSocialRef accountSocialRef = accountSocialRefMapper.selectByUserNameAndSocial(username, social);
        if (accountSocialRef == null) {
            return null;
        }
        return accountMapper.selectByPrimaryKey(accountSocialRef.getAccountId());
    }

    @Transactional(rollbackFor = RuntimeException.class)
    public int saveAccount(Account account, AccountSocialRef accountSocialRef) {
        int count = accountMapper.insert(account);
        accountSocialRef.setAccountId(account.getAccountId());
        accountSocialRefMapper.insert(accountSocialRef);
        return count;
    }

    public Account queryByAccountId(int accountId) {
        return accountMapper.selectByPrimaryKey(accountId);
    }
}
