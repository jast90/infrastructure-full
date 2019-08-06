package me.jastz.https.entity;

/**
 * Created by zhiwen on 2016/12/27.
 */
public class Data {
    private String secretStr;
    private String buttonTextInfo;
    private QueryLeftNewDTO queryLeftNewDTO;

    public String getSecretStr() {
        return secretStr;
    }

    public void setSecretStr(String secretStr) {
        this.secretStr = secretStr;
    }

    public String getButtonTextInfo() {
        return buttonTextInfo;
    }

    public void setButtonTextInfo(String buttonTextInfo) {
        this.buttonTextInfo = buttonTextInfo;
    }

    public QueryLeftNewDTO getQueryLeftNewDTO() {
        return queryLeftNewDTO;
    }

    public void setQueryLeftNewDTO(QueryLeftNewDTO queryLeftNewDTO) {
        this.queryLeftNewDTO = queryLeftNewDTO;
    }
}
