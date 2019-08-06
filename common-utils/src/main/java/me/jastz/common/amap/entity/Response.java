package me.jastz.common.amap.entity;

/**
 * Created by zhiwen on 2017/6/12.
 */
public class Response{
    private String status;
    private String info;
    private String infocode;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getInfocode() {
        return infocode;
    }

    public void setInfocode(String infocode) {
        this.infocode = infocode;
    }
}
