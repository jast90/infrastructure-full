package me.jastz.common.json.result;

/**
 * @author zhiwen
 */
public enum SampleResult implements IResult {
    SUCCESS(0), FAIL(-1);

    private int resultCode;

    SampleResult(int resultCode) {
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
