package cn.jastz.open.service;

import cn.jastz.open.entity.AppPayConfig;
import cn.jastz.open.entity.AppPayConfigDetails;
import cn.jastz.open.form.AppPayConfigAddForm;
import cn.jastz.open.form.AppPayConfigDetailsAddForm;
import cn.jastz.open.mapper.AppPayConfigDetailsMapper;
import cn.jastz.open.mapper.AppPayConfigMapper;
import com.google.common.collect.Lists;
import com.sun.net.httpserver.Authenticator;
import me.jastz.common.json.result.IResult;
import me.jastz.common.json.result.SampleResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author zhiwen
 */
@Service
public class AppPayConfigService {
    @Autowired
    private AppPayConfigMapper appPayConfigMapper;

    @Autowired
    private AppPayConfigDetailsMapper appPayConfigDetailsMapper;

    @Transactional
    public IResult addAppPayConfig(AppPayConfigAddForm appPayConfigAddForm) {
        AppPayConfig appPayConfig = appPayConfigAddForm.toAppPayConfig();
        if (appPayConfigMapper.insert(appPayConfig) > 0) {
            List<AppPayConfigDetails> list = appPayConfigAddForm.toAppPayConfigDetails();
            list.forEach(appPayConfigDetails -> appPayConfigDetails.setAppPayConfigId(appPayConfig.getAppPayConfigId()));
            if (appPayConfigDetailsMapper.batchInsert(list) > 0) {
                return SampleResult.SUCCESS;
            }
        }
        return SampleResult.FAIL;
    }

    public IResult saveOrUpdatePayConfigDetails(long appPayConfigId, List<AppPayConfigDetailsAddForm> addFormList) {
        List<AppPayConfigDetails> list = Lists.newArrayList();
        addFormList.forEach(appPayConfigDetailsAddForm -> {
            AppPayConfigDetails appPayConfigDetails = new AppPayConfigDetails();
            appPayConfigDetails.setAppPayConfigId(appPayConfigId);
            appPayConfigDetails.setAttrName(appPayConfigDetailsAddForm.getAttrName().name());
            appPayConfigDetails.setAttrValue(appPayConfigDetailsAddForm.getAttrValue());
            list.add(appPayConfigDetails);
        });
        if (appPayConfigDetailsMapper.batchInsert(list) > 0) {
            return SampleResult.SUCCESS;
        }
        return SampleResult.FAIL;
    }
}
