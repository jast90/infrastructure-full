package me.jastz.common.json.result;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * i18n properties 文件所在位置是
 * resources/i18n/fail.properties
 * resources/i18n/success.properties
 *
 * @author zhiwen
 */
@JsonSerialize(using = IResultSerializer.class)
public interface IResult {

    int getResultCode();

    void setResultCode(int resultCode);

}
