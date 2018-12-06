package cn.jastz.aliyun.service;

import com.aliyuncs.ecs.model.v20140526.DescribeInstanceTypesRequest;
import com.aliyuncs.ecs.model.v20140526.DescribeInstanceTypesResponse;
import com.aliyuncs.exceptions.ClientException;

import java.util.List;

/**
 * @author zhiwen
 */
public class ECSInstanceTypeService extends BaseService {

    public ECSInstanceTypeService() {
    }

    public ECSInstanceTypeService(String regionId, String accessKeyId, String accessKeySecret) {
        super(regionId, accessKeyId, accessKeySecret);
    }

    /**
     * 获取ECS实例类型
     *
     * @param instanceTypeFamily
     * @return
     */
    public List<DescribeInstanceTypesResponse.InstanceType> types(String instanceTypeFamily) {
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
