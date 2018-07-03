package cn.jastz.cms.controller;

import cn.jastz.page.domain.PageRequest;
import cn.jastz.post.client.PostClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

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


    @GetMapping("archives")
    public String archives(Model model, @RequestParam(value = "year", required = false, defaultValue = "0") int year) {
        if (year == 0 || year < 0) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            year = calendar.get(Calendar.YEAR);
        }
        model.addAttribute("list", postClient.queryByYear(year));
        List<Integer> years = postClient.queryPostYears();
        model.addAttribute("years", years);
        model.addAttribute("year", year);
        return "post/archives";
    }
}
