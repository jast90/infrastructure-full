package cn.jastz;

import cn.jastz.account.AccountServiceApplication;
import cn.jastz.account.entity.Account;
import cn.jastz.account.entity.AccountSocialRef;
import cn.jastz.account.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zhiwen
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AccountServiceApplication.class)
@ActiveProfiles("ubox")
public class AccountApplicationTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void test() {
        Account account = new Account();
        account.setAccountFrom("github");
        account.setAccountName("test");
        account.setAppId("123");
        AccountSocialRef accountSocialRef = new AccountSocialRef();
        accountSocialRef.setAppId("123");
        accountSocialRef.setSocial("github");
        accountSocialRef.setUsername("test");
        accountService.saveAccount(account, accountSocialRef);
    }

}
