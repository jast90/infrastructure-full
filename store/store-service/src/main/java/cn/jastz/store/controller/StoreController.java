package cn.jastz.store.controller;

import cn.jastz.common.controller.CommonBaseController;
import cn.jastz.page.domain.Page;
import cn.jastz.page.domain.PageRequest;
import cn.jastz.store.entity.Store;
import cn.jastz.store.form.StoreAddForm;
import cn.jastz.store.form.StoreAddSkuForm;
import cn.jastz.store.result.StoreResult;
import cn.jastz.store.service.StoreService;
import me.jastz.common.json.result.IResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhiwen
 */
@RestController

public class StoreController extends CommonBaseController {
    @Autowired
    private StoreService storeService;

    @PostMapping("store")
    public IResult addStore(@RequestBody StoreAddForm storeAddForm) {
        System.out.println("appId is " + getAppId());
        if (storeService.addStore(storeAddForm)) {
            return StoreResult.SUCCESS;
        } else {
            return StoreResult.FAIL;
        }
    }


    @PostMapping("store/batchAddStoreSku")
    public IResult batchAddStoreSku(@RequestBody StoreAddSkuForm storeAddSkuForm) {
        if (storeService.batchAddStoreSku(storeAddSkuForm)) {
            return StoreResult.SUCCESS;
        } else {
            return StoreResult.FAIL;
        }
    }

    @PostMapping("store/page")
    public Page<Store> queryPage(@RequestBody PageRequest pageRequest) {
        return storeService.queryPage(pageRequest);
    }
}

