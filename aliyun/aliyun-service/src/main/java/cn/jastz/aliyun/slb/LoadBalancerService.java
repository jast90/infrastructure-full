package cn.jastz.aliyun.slb;

import cn.jastz.aliyun.BaseService;
import cn.jastz.aliyun.slb.modal.LBCreateForm;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.slb.model.v20140515.*;
import me.jastz.common.json.JsonUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * 参考：https://help.aliyun.com/document_detail/27577.html?spm=a2c4g.11186623.3.3.6def4267gIpmeg
 *
 * @author zhiwen
 */
public class LoadBalancerService extends BaseService {

    public LoadBalancerService() {
    }

    public LoadBalancerService(String regionId, String accessKeyId, String accessKeySecret) {
        super(regionId, accessKeyId, accessKeySecret);
    }

    public CreateLoadBalancerResponse create(LBCreateForm lbCreateForm) throws ClientException {
        CreateLoadBalancerResponse createLoadBalancerResponse;
        try {
            createLoadBalancerResponse = getClient().getAcsResponse(lbCreateForm.toCreateLoadBalancerRequest());
            return createLoadBalancerResponse;
        } catch (ClientException e) {
            throw e;
        }
    }

    public boolean delete(String regionId, String loadBalancerId) throws ClientException {
        DeleteLoadBalancerRequest deleteLoadBalancerRequest = new DeleteLoadBalancerRequest();
        deleteLoadBalancerRequest.setRegionId(regionId);
        deleteLoadBalancerRequest.setLoadBalancerId(loadBalancerId);
        DeleteLoadBalancerResponse deleteLoadBalancerResponse;
        deleteLoadBalancerResponse = getClient().getAcsResponse(deleteLoadBalancerRequest);
        if (StringUtils.isNotEmpty(deleteLoadBalancerResponse.getRequestId())) {
            return true;
        }
        return false;
    }

    /**
     * 添加后端服务器。
     * <p>
     * 参考：https://help.aliyun.com/document_detail/27632.html?spm=a2c4g.11186623.6.640.ec6879311xjNw3
     *
     * @param loadBalancerId
     * @param backendServers ServerId：ECS实例ID。
     * @return
     * @throws ClientException
     */
    public AddBackendServersResponse addBackendServer(String loadBalancerId, List<RemoveBackendServersResponse.BackendServer> backendServers) throws ClientException {
        AddBackendServersRequest addBackendServersRequest = new AddBackendServersRequest();
        addBackendServersRequest.setLoadBalancerId(loadBalancerId);
        addBackendServersRequest.setBackendServers(JsonUtil.objectToJson(backendServers));
        AddBackendServersResponse addBackendServersResponse;
        addBackendServersResponse = getClient().getAcsResponse(addBackendServersRequest);
        return addBackendServersResponse;
    }

    /**
     * 移除后端服务器。
     * <p>
     * 参考：https://help.aliyun.com/document_detail/27633.html?spm=a2c4g.11186623.6.641.7e684f90k1C76f
     *
     * @param loadBalancerId
     * @param backendServerIds ECS实例ID 列表。
     * @throws ClientException
     */
    public RemoveBackendServersResponse removeBackendServer(String regionId, String loadBalancerId, List<String> backendServerIds) throws ClientException {
        RemoveBackendServersRequest removeBackendServersRequest = new RemoveBackendServersRequest();
        removeBackendServersRequest.setRegionId(regionId);
        removeBackendServersRequest.setLoadBalancerId(loadBalancerId);
        removeBackendServersRequest.setBackendServers(JsonUtil.objectToJson(backendServerIds));
        return getClient().getAcsResponse(removeBackendServersRequest);
    }


    /**
     * 设置后端服务器权重。
     * 参考：https://help.aliyun.com/document_detail/27634.html?spm=a2c4g.11186623.6.642.34ca7931QF0js6
     *
     * @param regionId
     * @param loadBalancerId
     * @param backendServers
     * @return
     * @throws ClientException
     */
    public SetBackendServersResponse setBackendServers(String regionId, String loadBalancerId, List<RemoveBackendServersResponse.BackendServer> backendServers) throws ClientException {
        SetBackendServersRequest setBackendServersRequest = new SetBackendServersRequest();
        setBackendServersRequest.setRegionId(regionId);
        setBackendServersRequest.setLoadBalancerId(loadBalancerId);
        setBackendServersRequest.setBackendServers(JsonUtil.objectToJson(backendServers));
        SetBackendServersResponse setBackendServersResponse = getClient().getAcsResponse(setBackendServersRequest);
        return setBackendServersResponse;

    }

    /**
     * 查询后端服务器的健康状态。
     *
     * @param regionId
     * @param loadBalancerId
     * @param port
     * @return
     * @throws ClientException
     */
    public DescribeHealthStatusResponse describeHealthStatus(String regionId, String loadBalancerId, Integer port) throws ClientException {
        DescribeHealthStatusRequest describeHealthStatusRequest = new DescribeHealthStatusRequest();
        describeHealthStatusRequest.setRegionId(regionId);
        describeHealthStatusRequest.setLoadBalancerId(loadBalancerId);
        describeHealthStatusRequest.setListenerPort(port);
        DescribeHealthStatusResponse describeHealthStatusResponse = getClient().getAcsResponse(describeHealthStatusRequest);
        return describeHealthStatusResponse;
    }
}
