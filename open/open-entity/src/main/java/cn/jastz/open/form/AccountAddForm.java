package cn.jastz.open.form;

import cn.jastz.open.entity.Account;
import cn.jastz.open.entity.AccountSocialRef;

/**
 * @author zhiwen
 */
public class AccountAddForm {
    private Account account;
    private AccountSocialRef accountSocialRef;
    private String password;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public AccountSocialRef getAccountSocialRef() {
        return accountSocialRef;
    }

    public void setAccountSocialRef(AccountSocialRef accountSocialRef) {
        this.accountSocialRef = accountSocialRef;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
