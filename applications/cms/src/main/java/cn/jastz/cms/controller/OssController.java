package cn.jastz.cms.controller;

import cn.jastz.cms.CmsApplication;
import cn.jastz.oss.client.OssClient;
import cn.jastz.oss.form.UploadFileForm;
import me.jastz.common.aliyun.oss.AliYunOssTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.Objects;

/**
 * @author zhiwen
 */
@RestController
public class OssController {
    @Autowired
    private OssClient ossClient;

    @Autowired
    private AliYunOssTemplate aliYunOssTemplate;

    @PostMapping("upload")
    public UploadResult uploadFile(HttpServletRequest request) {
        UploadResult result = new UploadResult();
        try {
            Part part = request.getPart("editormd-image-file");
            String fileName = getFileName(part);
            System.out.println(fileName);
            UploadFileForm uploadFileForm = new UploadFileForm();
            uploadFileForm.setFileName(fileName);
            uploadFileForm.setInputStream(part.getInputStream());
//            String url = ossClient.uploadFile(uploadFileForm);
            String url = uploadFile(uploadFileForm);
            if (Objects.equals("", url) == false) {
                result.setSuccess(1);
                result.setMessage("上传成功");
                result.setUrl(url);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
        return result;
    }

    public String uploadFile(UploadFileForm uploadFileForm) {
        String bucketName = "jastz-cms";
        if (!aliYunOssTemplate.bucketOperations().exist(bucketName)) {
            aliYunOssTemplate.bucketOperations().create(bucketName);
        }
        if (aliYunOssTemplate.simpleUploadOperations().uploadInputStream(bucketName, uploadFileForm.getFileName(), uploadFileForm.getInputStream())) {
            return String.format("http://%s.%s/%s", bucketName, CmsApplication.ossEndpoint, uploadFileForm.getFileName());
        } else {
            return "";
        }
    }

    private String getFileName(final Part part) {
        final String partHeader = part.getHeader("content-disposition");
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }

    public static class UploadResult {
        private int success = 0;
        private String message = "上传失败";
        private String url;

        public int getSuccess() {
            return success;
        }

        public void setSuccess(int success) {
            this.success = success;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
