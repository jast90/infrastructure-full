package cn.jastz.aliyun.ecs.instance.modal;

import com.aliyuncs.ecs.model.v20140526.CreateInstanceRequest;

/**
 * 参考：https://help.aliyun.com/document_detail/25499.html?spm=a2c4g.11186623.6.908.654e2eafiUTtjw
 *
 * @author zhiwen
 */
public class ECSCreateForm {
    private String regionId = "cn-shenzhen";
    /**
     * 镜像ID可以到Aliyun镜像市场寻找：https://market.aliyun.com/products/53400005?spm=5176.730005-53366009-53448001.listsearchfilter11.23.40ff3524UuBzRy，可以的话自己制作
     */
    private String imageId = "m-wz9bgzk74po1yvkzxdg5";
    /**
     * 取值：com.aliyuncs.ecs.model.v20140526.DescribeInstanceTypesResponse.InstanceType#instanceTypeId，
     * 如：ecs.t1.small
     */
    private String InstanceType = "ecs.t5-lc1m1.small";

    /**
     * ECS 可以创建安全组，https://ecs.console.aliyun.com/?spm=5176.ecsbuyv3.securityGroup.3.5ee03675ZFPUle#/securityGroup/region/cn-shenzhen。
     * 同一个安全组内的实例之间可以互相访问。
     */
    private String securityGroupId = "sg-wz92d8204k2lmpaa07jq";
    /**
     * 云服务器的主机名,如：ExpressMe01
     */
    private String hostName = "ExpressMe01";

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getSecurityGroupId() {
        return securityGroupId;
    }

    public void setSecurityGroupId(String securityGroupId) {
        this.securityGroupId = securityGroupId;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getInstanceType() {
        return InstanceType;
    }

    public void setInstanceType(String instanceType) {
        InstanceType = instanceType;
    }

    public void updateRequest(CreateInstanceRequest createInstanceRequest) {
        createInstanceRequest.setRegionId(getRegionId());
        createInstanceRequest.setImageId(getImageId());
        createInstanceRequest.setInstanceType(getInstanceType());
        createInstanceRequest.setSecurityGroupId(getSecurityGroupId());
        createInstanceRequest.setHostName(getHostName());
    }
}
