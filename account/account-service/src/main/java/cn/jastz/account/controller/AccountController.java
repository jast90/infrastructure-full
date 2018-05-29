package cn.jastz.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zhiwen
 */
@RequestMapping("account")
@Controller
public class AccountController {

    @Autowired
    private HttpServletRequest request;

    @GetMapping("logout")
    public String logout() {
        request.getSession().invalidate();
        return "redirect:/";
    }
}
