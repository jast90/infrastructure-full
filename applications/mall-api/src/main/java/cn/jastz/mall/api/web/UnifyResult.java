package cn.jastz.mall.api.web;

/**
 * @author zhiwen
 */
public class UnifyResult {
    private int resultCode = 0;
    private String resultMsg = "success";
    private Object data;

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
