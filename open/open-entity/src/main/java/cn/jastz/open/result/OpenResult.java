package cn.jastz.open.result;

import me.jastz.common.json.result.IResult;

/**
 * @author zhiwen
 */
public enum OpenResult implements IResult {
    SUCCESS(0),
    FAIL(-1);

    private int resultCode;

    private OpenResult(int resultCode) {
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
