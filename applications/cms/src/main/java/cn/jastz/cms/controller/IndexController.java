package cn.jastz.cms.controller;

import cn.jastz.page.domain.PageRequest;
import cn.jastz.post.client.PostClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author zhiwen
 */
@Controller
public class IndexController {
    @Autowired
    private PostClient postClient;

    @GetMapping("")
    public String index(Model model) {

        model.addAttribute("page", postClient.queryPage(PageRequest.of(0, 15)));
        return "index";
    }
}
