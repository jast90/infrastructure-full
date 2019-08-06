package me.jastz.common.alipay.domain;

/**
 * @author zhiwen
 */
public class AliPayResult<T> {
    private String sign;
    private T t;

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
