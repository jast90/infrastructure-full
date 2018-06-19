package cn.jastz.cms.controller.base;

import cn.jastz.cms.Constants;
import cn.jastz.cms.exception.UserNotLoginException;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;

/**
 * @author zhiwen
 */
public class BaseController {
    @Autowired
    protected HttpSession session;

    public int getCurrentAccountId() {
        int accountId = -1;
        try {
            accountId = Integer.parseInt((String) session.getAttribute(Constants.CURRENT_ACCOUNT_ID));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (accountId != -1) {
            return accountId;
        }
        throw new UserNotLoginException("User not login ");
    }
}
