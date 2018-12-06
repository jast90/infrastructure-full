package cn.jastz.aliyun.slb.modal;

import com.aliyuncs.slb.model.v20140515.CreateLoadBalancerRequest;

/**
 * @author zhiwen
 */
public class LBCreateForm {
    private String regionId;
    /**
     * 负载均衡实例的规格。取值：
     * slb.s1.small
     * slb.s2.small
     * slb.s2.medium
     * slb.s3.small
     * slb.s3.medium
     * slb.s3.large
     * 说明：若不指定规格，则创建性能共享型实例。
     */
    private String loadBalancerSpec;
    /**
     * 负载均衡实例的名称。
     * 长度为 2-128个字符，必须以英文字母开头，可包含数字，点号（.），下划线（_）和短横线（-）。
     */
    private String loadBalancerName = "infrastructureSLB01";
    /**
     * 实例的计费类型，取值：
     * PayOnDemand：按量付费
     * PrePay：预付费
     */
    private String payType = "PayOnDemand";

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getLoadBalancerSpec() {
        return loadBalancerSpec;
    }

    public void setLoadBalancerSpec(String loadBalancerSpec) {
        this.loadBalancerSpec = loadBalancerSpec;
    }

    public String getLoadBalancerName() {
        return loadBalancerName;
    }

    public void setLoadBalancerName(String loadBalancerName) {
        this.loadBalancerName = loadBalancerName;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public CreateLoadBalancerRequest toCreateLoadBalancerRequest() {
        CreateLoadBalancerRequest createLoadBalancerRequest = new CreateLoadBalancerRequest();
        createLoadBalancerRequest.setRegionId(getRegionId());
        createLoadBalancerRequest.setLoadBalancerSpec(getLoadBalancerSpec());
        createLoadBalancerRequest.setLoadBalancerName(getLoadBalancerName());
        createLoadBalancerRequest.setPayType(getPayType());
        return createLoadBalancerRequest;
    }
}
