package me.jastz.common.aliyun.oss.upload;

import com.aliyun.oss.OSS;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;

/**
 * @author zhiwen
 */
public class SimpleUploadOperationsImpl implements SimpleUploadOperations {
    private OSS oss;

    public SimpleUploadOperationsImpl(OSS oss) {
        this.oss = oss;
    }

    @Override
    public boolean uploadString(String bucketName, String objectName, String content) {
        boolean result = false;
        try {
            oss.putObject(bucketName, objectName, new ByteArrayInputStream(content.getBytes()));
            result = true;
        } catch (Exception e) {

        }
        return result;
    }

    @Override
    public boolean uploadByteArray(String bucketName, String objectName, byte[] content) {
        boolean result = false;
        try {
            oss.putObject(bucketName, objectName, new ByteArrayInputStream(content));
            result = true;
        } catch (Exception e) {

        }
        return result;
    }

    @Override
    public boolean uploadInputStream(String bucketName, String objectName, InputStream inputStream) {
        boolean result = false;
        try {
            oss.putObject(bucketName, objectName, inputStream);
            result = true;
        } catch (Exception e) {

        }
        return result;
    }

    @Override
    public boolean uploadFile(String bucketName, String objectName, File file) {
        boolean result = false;
        try {
            oss.putObject(bucketName, objectName, file);
            result = true;
        } catch (Exception e) {

        }
        return result;
    }

    @Override
    public boolean createFolder(String bucketName, String folderName) {
        boolean result = false;
        try {
            oss.putObject(bucketName, folderName, new ByteArrayInputStream(new byte[0]));
            result = true;
        } catch (Exception e) {

        }
        return result;
    }
}
