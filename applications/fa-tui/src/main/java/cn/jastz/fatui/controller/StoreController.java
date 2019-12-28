package cn.jastz.fatui.controller;

import cn.jastz.fatui.entity.Store;
import cn.jastz.fatui.service.StoreService;
import cn.jastz.page.domain.Page;
import cn.jastz.page.domain.PageRequest;
import me.jastz.common.json.result.IResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangzhiwen on 2019/12/21
 **/
@RestController
public class StoreController {
    @Autowired
    private StoreService storeService;

    @PostMapping("store/apply")
    public IResult apply(@RequestBody Store store){
        return storeService.add(store);
    }

    @PostMapping("/store/page")
    public Page<Store> page(@RequestBody PageRequest pageRequest){
        return storeService.page(pageRequest, Sort.by("create_time").descending());
    }
}
