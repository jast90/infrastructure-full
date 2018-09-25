package cn.jastz.mall.controller;

import cn.jastz.mall.form.MallStoreAddSkuForm;
import cn.jastz.mall.result.MallResult;
import cn.jastz.mall.service.StoreService;
import cn.jastz.page.domain.Page;
import cn.jastz.page.domain.PageRequest;
import cn.jastz.store.client.StoreClient;
import cn.jastz.store.entity.Store;
import cn.jastz.store.form.StoreAddForm;
import cn.jastz.store.result.StoreResult;
import me.jastz.common.json.result.IResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhiwen
 */
@Controller
public class StoreController {
    @Autowired
    private StoreClient storeClient;

    @Autowired
    private StoreService storeService;

    @GetMapping("store")
    public String addStore() {
        return "store/add";
    }

    @GetMapping("store/page/{page}")
    public String queryPage(Model model, @PathVariable("page") int page, @RequestParam(defaultValue = "12", name = "size") int size) {
        Page<Store> pageStore = storeClient.queryPage(PageRequest.of(page - 1, size));
        model.addAttribute("page", pageStore);
        return "store/page";
    }

    @ResponseBody
    @PostMapping("store")
    public IResult addStore(StoreAddForm storeAddForm) {
        if (storeClient.addStore(storeAddForm).getResultCode() == StoreResult.SUCCESS.getResultCode()) {
            return MallResult.SUCCESS;
        }
        return MallResult.FAIL;
    }

    @ResponseBody
    @PostMapping("store/sku/batch/add")
    public IResult batchAddStoreSku(MallStoreAddSkuForm mallStoreAddSkuForm) {
        return storeService.batchAddStoreSku(mallStoreAddSkuForm);
    }

    @GetMapping("store/sku/stock/{storeId}")
    public String queryAllStoreSkuStockByStoreId(@PathVariable("storeId") int storeId, Model model) {
        model.addAttribute("list", storeService.queryAllStoreSkuStockByStoreId(storeId));
        return "store/sku/list";
    }
}
