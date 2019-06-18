package cn.jastz.mq.result;

import me.jastz.common.json.result.IResult;

/**
 * @author zhiwen
 */
public enum MQFailResult implements IResult {
    ERROR(-1),
    TIMEOUT(10000);

    private int resultCode;

    MQFailResult(int resultCode) {
        this.resultCode = resultCode;
    }

    @Override
    public int getResultCode() {
        return resultCode;
    }

    @Override
    public void setResultCode(int i) {
        resultCode = i;
    }
}
