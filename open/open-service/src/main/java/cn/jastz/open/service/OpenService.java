package cn.jastz.open.service;

import cn.jastz.open.entity.App;
import cn.jastz.open.mapper.AppMapper;
import cn.jastz.page.domain.Page;
import cn.jastz.page.domain.PageList;
import cn.jastz.page.domain.PageRequest;
import me.jastz.common.json.result.IResult;
import me.jastz.common.json.result.SampleResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class OpenService {

    @Autowired
    private AppMapper appMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public IResult saveApp(App app) {
        app.setAppSecret(passwordEncoder.encode(app.getAppSecret()));
        IResult iResult = SampleResult.FAIL;
        if (appMapper.insert(app) == 1) {
            iResult = SampleResult.SUCCESS;
        }
        return iResult;
    }


    public Page<App> findAppByPage(PageRequest pageRequest) {
        PageList<App> pageList = (PageList) appMapper.queryPage(pageRequest);
        return pageList.getPage();
    }
}
