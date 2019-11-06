package cn.jastz.product.service;

import me.jastz.common.json.JsonUtil;
import me.jastz.common.stackoverflow.SofUserOperationsImpl;
import me.jastz.common.stackoverflow.vo.UserVo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author zhangzhiwen on 2019/10/26
 **/
public class StackOverFlowServiceTest extends BaseTest {
    @Autowired
    private StackOverFlowService stackOverFlowService;

    @Test
    public void batchInsert() {
        RestTemplate restTemplate = new RestTemplate();
        SofUserOperationsImpl sofUserOperations = new SofUserOperationsImpl(restTemplate);
        int totalPages = 10000;
        List<UserVo> userVos;
        for (int page = 9391+1; page < totalPages; page++) {
            userVos = sofUserOperations.page(page, "reputation", "all");
            for (UserVo userVo : userVos) {
                userVo.setPage(page);
            }
            if (CollectionUtils.isEmpty(userVos) == false) {
                stackOverFlowService.batchInsert(userVos);
            }
            userVos = null;
        }

    }

}
