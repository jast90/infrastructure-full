package cn.jastz;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author zhiwen
 */
@Controller
public class HelloController {
    @GetMapping
    public String hello(Model model) {
        model.addAttribute("hello", "hello");
        return "hello";
    }
}
