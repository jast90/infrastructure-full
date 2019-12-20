package me.jastz.common.juejin.xiangqin;

import com.google.common.collect.Maps;
import me.jastz.common.json.JsonUtil;
import me.jastz.common.juejin.JueJinURLs;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @author zhangzhiwen on 2019/11/26
 **/
public class XiangQinOperationsImpl implements XiangQinOperations{

    private RestTemplate restTemplate;

    public XiangQinOperationsImpl() {
        restTemplate = new RestTemplate();
    }

    public XiangQinOperationsImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public XiangQinResp page(String uid, String deviceId, String token, String topic, int page, int pageSize) {
        Map<String, Object> params = Maps.newHashMap();
        params.put("uid", uid);
        params.put("deviceId", deviceId);
        params.put("token", token);
        params.put("topicId", topic);
        params.put("page", page);
        params.put("pageSize", pageSize);
        XiangQinResp resp = restTemplate.getForObject(JueJinURLs.xiangqin.getUrl(),XiangQinResp.class,params);
        return resp;
    }


    public static void main(String[] args) {
        XiangQinOperationsImpl impl = new XiangQinOperationsImpl();
        /**
         * https://short-msg-ms.juejin.im/v1/pinList/topic?uid=5ddcb4fc6fb9a07a99508301&device_id=1574745340634&token=eyJhY2Nlc3NfdG9rZW4iOiI2QzBpRXBablBwTnY1TW1YIiwicmVmcmVzaF90b2tlbiI6IkZIUUJzMVE3TUdKdnJYMnEiLCJ0b2tlbl90eXBlIjoibWFjIiwiZXhwaXJlX2luIjoyNTkyMDAwfQ%3D%3D&src=web&topicId=5abcaa67092dcb4620ca335c&page=1&pageSize=100&sortType=rank
         */
        XiangQinResp xiangQinResp = impl.page("5ddcb4fc6fb9a07a99508301","1574745340634",
                "eyJhY2Nlc3NfdG9rZW4iOiI2QzBpRXBablBwTnY1TW1YIiwicmVmcmVzaF90b2tlbiI6IkZIUUJzMVE3TUdKdnJYMnEiLCJ0b2tlbl90eXBlIjoibWFjIiwiZXhwaXJlX2luIjoyNTkyMDAwfQ%3D%3D",
                "5abcaa67092dcb4620ca335c",1,100);
        System.out.println(JsonUtil.objectToPrettyJson(xiangQinResp));
    }
}
