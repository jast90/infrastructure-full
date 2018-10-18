package cn.jastz.open.service;

import cn.jastz.open.entity.App;
import cn.jastz.open.entity.AppSocialRef;
import cn.jastz.open.mapper.AppMapper;
import cn.jastz.open.mapper.AppSocialRefMapper;
import cn.jastz.page.domain.Page;
import cn.jastz.page.domain.PageList;
import cn.jastz.page.domain.PageRequest;
import com.netflix.discovery.converters.Auto;
import me.jastz.common.json.result.IResult;
import me.jastz.common.json.result.SampleResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OpenService {

    @Autowired
    private AppMapper appMapper;

    public IResult saveApp(App app) {
        app.setAppId(UUID.randomUUID().toString().replace("-", ""));
        app.setAppSecret(UUID.randomUUID().toString().replace("-", ""));
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
