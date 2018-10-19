package cn.jastz.open.controller;

import cn.jastz.open.entity.App;
import cn.jastz.open.entity.AppSocialRef;
import cn.jastz.open.mapper.AppMapper;
import cn.jastz.open.mapper.AppSocialRefMapper;
import me.jastz.common.json.result.IResult;
import me.jastz.common.json.result.SampleResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhiwen
 */
@RestController
public class AppController extends BaseController {

    @Autowired
    private AppMapper appMapper;

    @Autowired
    private AppSocialRefMapper appSocialRefMapper;

    @GetMapping("app/{appId}")
    public App getById(@PathVariable("appId") String appId) {
        return appMapper.selectByPrimaryKey(appId);
    }

    @PostMapping("/app/socialRef")
    public IResult addAppSocialRef(AppSocialRef appSocialRef) {
        if (appSocialRefMapper.insert(appSocialRef) > 0) {
            return SampleResult.SUCCESS;
        }
        return SampleResult.FAIL;
    }
}
