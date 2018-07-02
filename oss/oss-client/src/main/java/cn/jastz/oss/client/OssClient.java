package cn.jastz.oss.client;

import cn.jastz.oss.form.UploadFileForm;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author zhiwen
 */
@FeignClient("oss")
public interface OssClient {

    @PostMapping("oss/upload/file")
    String uploadFile(@RequestBody UploadFileForm uploadFileForm);
}
