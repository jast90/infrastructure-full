package cn.jastz.store.form;

import cn.jastz.store.entity.Store;
import org.springframework.beans.BeanUtils;

import java.util.Date;

/**
 * @author zhiwen
 */
public class StoreAddForm {
    private String storeName;
    private String address;

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Store to() {
        Store store = new Store();
        BeanUtils.copyProperties(this, store);
        store.setCreatedTime(new Date());
        return store;
    }
}
