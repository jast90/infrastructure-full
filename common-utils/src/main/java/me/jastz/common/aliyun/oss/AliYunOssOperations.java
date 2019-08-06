package me.jastz.common.aliyun.oss;

import me.jastz.common.aliyun.oss.bucket.BucketOperations;
import me.jastz.common.aliyun.oss.upload.SimpleUploadOperations;

/**
 * @author zhiwen
 */
public interface AliYunOssOperations {

    BucketOperations bucketOperations();

    SimpleUploadOperations simpleUploadOperations();

}
