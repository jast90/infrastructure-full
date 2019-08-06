package me.jastz.common.aliyun.oss.bucket;

import com.aliyun.oss.model.*;

import java.util.List;

/**
 * 参考<a href="https://help.aliyun.com/document_detail/32012.html?spm=a2c4g.11186623.6.680.DYoqkG">存储空间</a>
 *
 * @author zhiwen
 */
public interface BucketOperations {
    boolean create(String name);

    boolean create(String name, CannedAccessControlList cannedACL, StorageClass storageClass);

    List<Bucket> listAll();

    BucketList listByPrefix(String prefix);

    BucketList listByMarker(String marker);

    BucketList listByMaxKeys(int maxKeys);

    boolean exist(String name);

    boolean setBucketAcl(String name, CannedAccessControlList cannedACL);

    AccessControlList getBucketAcl(String name);

    String getLocation(String name);

    BucketInfo getBucketInfo(String name);

    boolean delete(String name);
}
