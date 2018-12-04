package cn.jastz.aliyun.service;

import cn.jastz.aliyun.ecs.ECSCreateForm;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.ecs.model.v20140526.CreateInstanceRequest;
import com.aliyuncs.ecs.model.v20140526.CreateInstanceResponse;
import com.aliyuncs.ecs.model.v20140526.DescribeInstanceTypesRequest;
import com.aliyuncs.ecs.model.v20140526.DescribeInstanceTypesResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;

import java.util.List;

/**
 * @author zhiwen
 */
public class AliyunECSService {

    private String regionId;
    private String accessKeyId;
    private String accessKeySecret;

    public AliyunECSService() {
    }

    public AliyunECSService(String regionId, String accessKeyId, String accessKeySecret) {
        this.regionId = regionId;
        this.accessKeyId = accessKeyId;
        this.accessKeySecret = accessKeySecret;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }

    private IAcsClient getClient() {
        return new DefaultAcsClient(DefaultProfile.getProfile(getRegionId(), getAccessKeyId(), getAccessKeySecret()));
    }

    public String createInstance(ECSCreateForm ecsCreateForm) {
        CreateInstanceRequest createInstanceRequest = new CreateInstanceRequest();
        CreateInstanceResponse createInstanceResponse;
        try {
            createInstanceResponse = getClient().getAcsResponse(createInstanceRequest);
            return createInstanceResponse.getInstanceId();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<DescribeInstanceTypesResponse.InstanceType> instanceType(String instanceTypeFamily) {
        DescribeInstanceTypesRequest describeInstanceTypesRequest = new DescribeInstanceTypesRequest();
        describeInstanceTypesRequest.setInstanceTypeFamily(instanceTypeFamily);
        DescribeInstanceTypesResponse describeInstanceTypesResponse;
        try {
            describeInstanceTypesResponse = getClient().getAcsResponse(describeInstanceTypesRequest);
            List<DescribeInstanceTypesResponse.InstanceType> instanceTypes = describeInstanceTypesResponse.getInstanceTypes();
            return instanceTypes;
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return null;
    }
}
