package cn.jastz.product.service;

import com.google.common.collect.Lists;
import me.jastz.common.json.JsonUtil;
import me.jastz.common.juejin.xiangqin.XiangQin;
import me.jastz.common.juejin.xiangqin.XiangQinOperationsImpl;
import me.jastz.common.juejin.xiangqin.XiangQinResp;
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
public class JueJinServiceTest extends BaseTest {
    @Autowired
    private JueJinService jueJinService;

    @Test
    public void batchInsert() {
        RestTemplate restTemplate = new RestTemplate();
        XiangQinOperationsImpl xiangQinOperations = new XiangQinOperationsImpl(restTemplate);
        List<XiangQin> list = Lists.newArrayList();
        for (int i = 0; i < 7; i++) {
            XiangQinResp resp = xiangQinOperations.page("5ddcb4fc6fb9a07a99508301", "1574745340634",
                    "eyJhY2Nlc3NfdG9rZW4iOiI2QzBpRXBablBwTnY1TW1YIiwicmVmcmVzaF90b2tlbiI6IkZIUUJzMVE3TUdKdnJYMnEiLCJ0b2tlbl90eXBlIjoibWFjIiwiZXhwaXJlX2luIjoyNTkyMDAwfQ%3D%3D",
                    "5abcaa67092dcb4620ca335c", i, 100);
            if (resp != null) {
                List<XiangQin> data = resp.getD().getList();
                list.addAll(data);
            }
        }
//        jueJinService.batchAdd(list);
        System.out.println(JsonUtil.objectToPrettyJson(list));
    }

}
