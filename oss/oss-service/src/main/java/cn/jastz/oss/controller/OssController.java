package cn.jastz.oss.controller;

import cn.jastz.oss.OssServiceApplication;
import cn.jastz.oss.form.UploadFileForm;
import me.jastz.common.aliyun.oss.AliYunOssTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhiwen
 */
@RestController
public class OssController {
    @Autowired
    private AliYunOssTemplate aliYunOssTemplate;

    @PostMapping("oss/upload/file")
    public String uploadFile(@RequestBody UploadFileForm uploadFileForm) {
        String bucketName = "cms";
        if (!aliYunOssTemplate.bucketOperations().exist(bucketName)) {
            aliYunOssTemplate.bucketOperations().create(bucketName);
        }
        if (aliYunOssTemplate.simpleUploadOperations().uploadInputStream(bucketName, uploadFileForm.getFileName(), uploadFileForm.getInputStream())) {
            return String.format("http://%s.%s/%s", bucketName, OssServiceApplication.ossEndpoint, uploadFileForm.getFileName());
        } else {
            return "";
        }
    }
}
