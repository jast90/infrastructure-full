package cn.jastz.store.controller;

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
public class StoreController {
    @Autowired
    private StoreService storeService;

    @PostMapping("store")
    public IResult addStore(@RequestBody StoreAddForm storeAddForm) {
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
}
