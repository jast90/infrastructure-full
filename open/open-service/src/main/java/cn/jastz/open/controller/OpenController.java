package cn.jastz.open.controller;

import cn.jastz.common.entity.enums.SocialEnum;
import cn.jastz.open.entity.App;
import cn.jastz.open.entity.AppSocialRef;
import cn.jastz.open.enums.AttrName;
import cn.jastz.open.enums.PayPlatform;
import cn.jastz.open.service.OpenService;
import cn.jastz.page.domain.Page;
import cn.jastz.page.domain.PageRequest;
import me.jastz.common.json.result.IResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("open")
public class OpenController {

    @Autowired
    private OpenService openService;

    @GetMapping("app")
    public String addApp() {
        return "app/add";
    }

    @ResponseBody
    @PostMapping("app")
    public IResult addApp(App app) {
        return openService.saveApp(app);
    }


    @GetMapping("app/page/{num}")
    public String findAppByPage(@PathVariable("num") int num, Model model) {
        PageRequest pageRequest = PageRequest.of(num - 1, 20);
        Page<App> page = openService.findAppByPage(pageRequest);
        model.addAttribute("page", page);
        model.addAttribute("socials", SocialEnum.values());
        model.addAttribute("attrNames", AttrName.values());
        model.addAttribute("payPlatforms", PayPlatform.values());
        return "app/list";
    }
}
