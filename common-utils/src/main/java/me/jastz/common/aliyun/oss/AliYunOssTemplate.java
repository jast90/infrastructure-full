package me.jastz.common.aliyun.oss;

import com.aliyun.oss.OSS;
import me.jastz.common.aliyun.oss.bucket.BucketOperations;
import me.jastz.common.aliyun.oss.bucket.BucketOperationsImpl;
import me.jastz.common.aliyun.oss.upload.SimpleUploadOperations;
import me.jastz.common.aliyun.oss.upload.SimpleUploadOperationsImpl;

/**
 * @author zhiwen
 */
public class AliYunOssTemplate implements AliYunOssOperations {

    private OSS ossClient;

    public AliYunOssTemplate(OSS ossClient) {
        this.ossClient = ossClient;
    }

    @Override
    public BucketOperations bucketOperations() {
        return new BucketOperationsImpl(ossClient);
    }

    @Override
    public SimpleUploadOperations simpleUploadOperations() {
        return new SimpleUploadOperationsImpl(ossClient);
    }
}
