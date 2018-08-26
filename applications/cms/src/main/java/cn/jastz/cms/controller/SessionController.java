package cn.jastz.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class SessionController {

    @Autowired
//    private HttpSession session;

    @GetMapping("session")
    public String hello(HttpSession session){
//        System.out.println(session.getId());
        return "hello";
    }
}
