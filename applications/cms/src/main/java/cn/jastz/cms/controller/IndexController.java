package cn.jastz.cms.controller;

import cn.jastz.oss.client.PostClient;
import cn.jastz.page.domain.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zhiwen
 */
@Controller
public class IndexController {
    @Autowired
    private PostClient postClient;

    @GetMapping("")
    public String index(Model model, @RequestParam(value = "page", required = false, defaultValue = "1") int page
            , @RequestParam(value = "size", required = false, defaultValue = "12") int size) {

        model.addAttribute("page", postClient.queryPage(PageRequest.of(page < 1 ? 0 : page - 1, size)));
        return "index";
    }
}
