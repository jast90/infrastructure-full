package me.jastz.common.china.district;

import me.jastz.common.json.JsonUtil;

import java.util.concurrent.Callable;

/**
 * @author zhiwen
 */
public class DijiThread implements Callable<City> {
    private City shengji;

    public DijiThread(City shengji) {
        this.shengji = shengji;
    }

    @Override
    public City call() throws Exception {
        shengji.setChildren(ProvinceHandler.getDiji(this.shengji.getName()));
        return shengji;
    }
}
