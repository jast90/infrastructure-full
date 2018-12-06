package cn.jastz.slb;

import cn.jastz.BaseTest;
import cn.jastz.aliyun.slb.LoadBalancerService;
import cn.jastz.aliyun.slb.modal.LBCreateForm;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.slb.model.v20140515.AddBackendServersResponse;
import com.aliyuncs.slb.model.v20140515.CreateLoadBalancerResponse;
import com.aliyuncs.slb.model.v20140515.RemoveBackendServersResponse;
import me.jastz.common.json.JsonUtil;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Test;

import javax.json.Json;
import java.util.List;

/**
 * @author zhiwen
 */
public class LoadBalancerServiceTest extends BaseTest {

    private LoadBalancerService loadBalancerService = new LoadBalancerService(region, key, secret);

    @Test
    public void create() {
        LBCreateForm lbCreateForm = new LBCreateForm();
        lbCreateForm.setRegionId(region);
        String loadBalancerId = null;
        try {
            CreateLoadBalancerResponse createLoadBalancerResponse = loadBalancerService.create(lbCreateForm);
            loadBalancerId = createLoadBalancerResponse.getLoadBalancerId();
            System.out.println(loadBalancerId);
        } catch (ClientException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(StringUtils.isNotEmpty(loadBalancerId));
    }

    @Test
    public void addBackendServer() {
        List<RemoveBackendServersResponse.BackendServer> backendServers = Lists.newArrayList();
        RemoveBackendServersResponse.BackendServer backendServer = new RemoveBackendServersResponse.BackendServer();
        backendServer.setServerId("i-wz9f89marb3odv3mu92y");
        backendServer.setWeight(100);
        backendServers.add(backendServer);
        try {
            AddBackendServersResponse response = loadBalancerService.addBackendServer("lb-wz98q8g69tk08oajqsmoa", backendServers);
            System.out.println(JsonUtil.objectToJson(response));
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
}
