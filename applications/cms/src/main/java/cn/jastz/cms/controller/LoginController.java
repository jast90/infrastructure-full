package cn.jastz.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zhiwen
 */
@Controller
public class LoginController {
    
    @GetMapping("login/{social}")
    public String login(@PathVariable("social") String social, Model model) {
        model.addAttribute("social", social);
        return "login/social";
    }

}
