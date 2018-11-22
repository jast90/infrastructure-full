package cn.jastz.express.controller;

import cn.jastz.common.controller.CommonBaseController;
import cn.jastz.express.entity.AccountExpress;
import cn.jastz.express.entity.form.AccountExpressAddForm;
import cn.jastz.express.entity.form.AccountExpressQueryLocationForm;
import cn.jastz.express.service.AccountExpressService;
import me.jastz.common.json.result.IResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zhiwen
 */
@RestController
@RequestMapping("account/express")
public class AccountExpressController extends CommonBaseController {

    @Autowired
    private AccountExpressService accountExpressService;

    @PostMapping("")
    public IResult addAccountExpress(@RequestBody AccountExpressAddForm accountExpressAddForm) {
        return accountExpressService.addAccountExpress(accountExpressAddForm, getAppId());
    }

    @PostMapping("list/byLocation")
    public List<AccountExpress> queryByLocation(@RequestBody AccountExpressQueryLocationForm queryLocationForm) {
        return accountExpressService.queryByLocation(queryLocationForm);
    }
}
