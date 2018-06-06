package cn.jastz.open.controller;

import cn.jastz.open.entity.App;
import cn.jastz.open.mapper.AppMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhiwen
 */
@RestController
@RequestMapping("app")
public class AppController extends BaseController {

    @Autowired
    private AppMapper appMapper;

    @GetMapping("{appId}")
    public App getById(@PathVariable("appId") String appId) {
        return appMapper.selectByPrimaryKey(appId);
    }
}
