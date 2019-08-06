package me.jastz.common.aliyun.oss.upload;

import java.io.File;
import java.io.InputStream;

/**
 * 参考：<a href="https://help.aliyun.com/document_detail/84781.html?spm=a2c4g.11186623.6.683.arCgOT">简单上传</a>
 *
 * @author zhiwen
 */
public interface SimpleUploadOperations {
    boolean uploadString(String bucketName, String objectName, String content);

    boolean uploadByteArray(String bucketName, String objectName, byte[] content);

    boolean uploadInputStream(String bucketName, String objectName, InputStream inputStream);

    boolean uploadFile(String bucketName, String objectName, File file);

    boolean createFolder(String bucketName, String folderName);
}
