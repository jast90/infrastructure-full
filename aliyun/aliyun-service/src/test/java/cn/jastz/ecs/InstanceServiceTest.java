package cn.jastz.ecs;

import cn.jastz.BaseTest;
import cn.jastz.aliyun.ecs.instance.ECSInstanceService;
import cn.jastz.aliyun.ecs.instance.modal.ECSCreateForm;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author zhiwen
 */
public class InstanceServiceTest extends BaseTest {

    private ECSInstanceService instanceTypeService = new ECSInstanceService(region, key, secret);


    @Test
    public void createInstance() {
        String instanceId = instanceTypeService.create(new ECSCreateForm());
        System.out.println(instanceId);
        Assert.assertTrue(StringUtils.isNotEmpty(instanceId));
    }
}
