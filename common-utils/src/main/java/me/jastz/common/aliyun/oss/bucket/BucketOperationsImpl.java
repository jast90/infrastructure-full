package me.jastz.common.aliyun.oss.bucket;

import com.aliyun.oss.OSS;
import com.aliyun.oss.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author zhiwen
 */
public class BucketOperationsImpl implements BucketOperations {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private OSS ossClient;

    public BucketOperationsImpl(OSS ossClient) {
        this.ossClient = ossClient;
    }

    @Override
    public boolean create(String name) {
        Bucket bucket = null;
        try {
            bucket = ossClient.createBucket(name);
            logger.debug("create bucket:{} success", name);
        } catch (Exception e) {

        }

        return bucket != null;
    }

    @Override
    public boolean create(String name, CannedAccessControlList cannedACL, StorageClass storageClass) {
        CreateBucketRequest createBucketRequest = new CreateBucketRequest(name);
        // 设置存储空间的权限为公共读，默认是私有读写。
        createBucketRequest.setCannedACL(cannedACL);
        // 设置存储空间的存储类型为低频访问类型，默认是标准类型。
        createBucketRequest.setStorageClass(storageClass);
        Bucket bucket = ossClient.createBucket(createBucketRequest);
        return bucket.getResponse().getStatusCode() == 200;
    }

    @Override
    public List<Bucket> listAll() {
        List<Bucket> buckets = ossClient.listBuckets();
        return buckets;
    }

    @Override
    public BucketList listByPrefix(String prefix) {
        ListBucketsRequest listBucketsRequest = new ListBucketsRequest();
        // 列举指定前缀的存储空间，如果不指定前缀则列举所有的存储空间。
        listBucketsRequest.setPrefix(prefix);
        BucketList bucketList = ossClient.listBuckets(listBucketsRequest);
        return bucketList;
    }

    @Override
    public BucketList listByMarker(String marker) {
        ListBucketsRequest listBucketsRequest = new ListBucketsRequest();
        // 列举指定marker之后的存储空间，不设定marker则列举所有的存储空间。
        listBucketsRequest.setMarker(marker);
        BucketList bucketList = ossClient.listBuckets(listBucketsRequest);
        return bucketList;
    }

    @Override
    public BucketList listByMaxKeys(int maxKeys) {
        ListBucketsRequest listBucketsRequest = new ListBucketsRequest();
        // 限定此次列举存储空间的个数为500。默认值为100，最大值为1000。
        listBucketsRequest.setMaxKeys(maxKeys);
        BucketList bucketList = ossClient.listBuckets(listBucketsRequest);
        return bucketList;
    }

    @Override
    public boolean exist(String name) {
        boolean exist = ossClient.doesBucketExist(name);
        if (exist) {
            logger.debug("bucket:{} exist", name);
        } else {
            logger.debug("bucket:{} not exist", name);
        }
        return exist;
    }

    @Override
    public boolean setBucketAcl(String name, CannedAccessControlList cannedACL) {
        ossClient.setBucketAcl(name, cannedACL);
        return true;
    }

    @Override
    public AccessControlList getBucketAcl(String name) {
        // 获取存储空间的访问权限。
        AccessControlList acl = ossClient.getBucketAcl(name);
        return acl;
    }

    @Override
    public String getLocation(String name) {
        return ossClient.getBucketLocation(name);
    }

    @Override
    public BucketInfo getBucketInfo(String name) {
        BucketInfo info = ossClient.getBucketInfo(name);
        return info;
    }

    @Override
    public boolean delete(String name) {
        boolean result = false;
        try {
            ossClient.deleteBucket(name);
            result = true;
        } catch (Exception e) {

        }
        return result;
    }
}
