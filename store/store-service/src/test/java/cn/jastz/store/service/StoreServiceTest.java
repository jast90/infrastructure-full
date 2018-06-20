package cn.jastz.store.service;

import cn.jastz.store.BaseTest;
import cn.jastz.store.form.StoreAddForm;
import org.junit.Test;

/**
 * @author zhiwen
 */
public class StoreServiceTest extends BaseTest<StoreService> {
    @Test
    public void addStore() {
        StoreAddForm storeAddForm = new StoreAddForm();
        storeAddForm.setStoreName("测试门店");
        storeAddForm.setAddress("深圳市南山区深南大道9996号松日鼎盛大厦8层");
        service.addStore(storeAddForm);
    }

}
