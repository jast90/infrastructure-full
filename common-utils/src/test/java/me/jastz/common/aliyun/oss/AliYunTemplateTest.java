package me.jastz.common.aliyun.oss;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;

/**
 * @author zhiwen
 */
public class AliYunTemplateTest {
    private AliYunOssTemplate ossTemplate;

    public AliYunTemplateTest() {
        OSS oss = new OSSClientBuilder().build("oss-cn-beijing.aliyuncs.com", "", "");
        ossTemplate = new AliYunOssTemplate(oss);
    }

    @Test
    public void uploadFile() {
        File file = new File("E:\\jast\\common-utils\\target/common-utils-1.0-SNAPSHOT.jar");
        Assert.assertTrue(ossTemplate.simpleUploadOperations().uploadFile("jastz", file.getName(), file));
    }

    @Test
    public void create() {
        Assert.assertTrue(ossTemplate.bucketOperations().delete("jastzz"));
    }
}
