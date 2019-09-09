package cn.jastz.open.controller;

import cn.jastz.open.entity.AppPayConfig;
import cn.jastz.open.enums.PayPlatform;
import cn.jastz.open.form.AppPayConfigAddForm;
import cn.jastz.open.form.AppPayConfigDetailsAddForm;
import cn.jastz.open.service.AppPayConfigService;
import me.jastz.common.json.result.IResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zhiwen
 */
@RestController
@RequestMapping("/open/app/pay/config")
public class AppPayConfigController extends BaseController {

    @Autowired
    private AppPayConfigService appPayConfigService;

    @PostMapping("")
    public IResult add(@RequestBody AppPayConfigAddForm appPayConfigAddForm) {
        return appPayConfigService.addAppPayConfig(appPayConfigAddForm);
    }

    @PostMapping("{appPayConfigId}")
    public IResult addAttr(@PathVariable("appPayConfigId") long appPayConfigId, @RequestBody List<AppPayConfigDetailsAddForm> addFormList) {
        return appPayConfigService.saveOrUpdatePayConfigDetails(appPayConfigId, addFormList);
    }

    @GetMapping("")
    public List<AppPayConfig> getByAppId() {
        return appPayConfigService.queryByAppId(getCurrentAppId());
    }

    @GetMapping("{payPlatform}")
    public AppPayConfig getByAppIdAndPayPlatform(@PathVariable("payPlatform") PayPlatform payPlatform) {
        return appPayConfigService.queryByAppIdAndPayPlatform(getCurrentAppId(), payPlatform);
    }
}

