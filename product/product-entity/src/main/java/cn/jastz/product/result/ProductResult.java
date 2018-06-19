package cn.jastz.product.result;

import me.jastz.common.json.result.IResult;

/**
 * @author zhiwen
 */
public enum ProductResult implements IResult {
    SUCCESS(0),
    FAIL(-1);

    private int resultCode;

    private ProductResult(int resultCode) {
        this.resultCode = resultCode;
    }

    @Override
    public int getResultCode() {
        return this.resultCode;
    }

    @Override
    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    @Override
    public String toString() {
        return this.name();
    }
}
