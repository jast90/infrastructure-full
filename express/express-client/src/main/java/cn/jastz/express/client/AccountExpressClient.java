package cn.jastz.express.client;

import cn.jastz.express.entity.AccountExpress;
import cn.jastz.express.entity.form.AccountExpressAddForm;
import cn.jastz.express.entity.form.AccountExpressQueryLocationForm;
import me.jastz.common.json.result.IResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author zhiwen
 */
@FeignClient("express")
public interface AccountExpressClient {
    @PostMapping("account/express")
    IResult addAccountExpress(@RequestBody AccountExpressAddForm accountExpressAddForm);

    @PostMapping("account/express/list/byLocation")
    List<AccountExpress> queryByLocation(@RequestBody AccountExpressQueryLocationForm queryLocationForm);
}
