package cn.jastz.cms.social;

import cn.jastz.account.client.AccountClient;
import cn.jastz.account.entity.Account;
import cn.jastz.account.entity.AccountSocialRef;
import cn.jastz.account.form.AccountAddForm;
import cn.jastz.account.result.AccountResult;
import me.jastz.common.json.result.IResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UserProfile;

/**
 * @author jast
 */
public class MyConnectionSignUp implements ConnectionSignUp {

    @Autowired
    private AccountClient accountClient;

    public MyConnectionSignUp() {
        System.out.println("MyConnectionSignUp init");
    }

    @Override
    public String execute(Connection<?> connection) {
        String social = connection.getKey().getProviderId();
        UserProfile userProfile = connection.fetchUserProfile();
        Account account1 = accountClient.queryAccountByUsernameAndSocial(userProfile.getUsername(), social);
        if (account1 == null) {
            Account account = new Account();
            account.setAccountName(userProfile.getUsername());
            account.setAccountFrom(connection.getKey().getProviderId());

            AccountSocialRef accountSocialRef = new AccountSocialRef();
            accountSocialRef.setUsername(userProfile.getUsername());
            accountSocialRef.setFirstName(userProfile.getFirstName());
            accountSocialRef.setLastName(userProfile.getLastName());
            accountSocialRef.setEmail(userProfile.getEmail());
            accountSocialRef.setSocial(social);
            AccountAddForm accountAddForm = new AccountAddForm();
            accountAddForm.setAccount(account);
            accountAddForm.setAccountSocialRef(accountSocialRef);
            IResult result = accountClient.addAccount(accountAddForm);

            if (result.getResultCode() == AccountResult.SUCCESS.getResultCode()) {
                return String.valueOf(account.getAccountId());
            } else {
                return null;
            }
        } else {
            return String.valueOf(account1.getAccountId());
        }

    }
}
