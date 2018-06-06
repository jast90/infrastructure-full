package cn.jastz.cms.controller;

import cn.jastz.account.client.AccountClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @Autowired
    private AccountClient accountClient;
    @GetMapping("")
    public String login(){
        return "index";
    }
}
