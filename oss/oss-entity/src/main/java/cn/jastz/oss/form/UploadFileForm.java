package cn.jastz.oss.form;

import java.io.InputStream;

/**
 * @author zhiwen
 */
public class UploadFileForm {
    private String fileName;
    private InputStream inputStream;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }
}
