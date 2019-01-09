package cn.jastz.mall.api.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * 统一结果处理器
 *
 * @author zhiwen
 */
@ControllerAdvice
public class UnifyResultResponseBodyAdviceHandler implements ResponseBodyAdvice {
    /**
     * 需要忽略的统一结果的URL
     */
    @Value("${unify.result.ignore.urls:''}")
    private List<String> unifyResultIgnoreUrl;

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (unifyResultIgnoreUrl.contains(request.getURI().getPath())) {
            return body;
        }
        if (body != null && body instanceof LinkedHashMap && ((LinkedHashMap) body).containsKey("exception")) {
            UnifyResult unifyResult = new UnifyResult();
            unifyResult.setResultCode(-1);
            unifyResult.setResultMsg("system error");
            return unifyResult;
        }
        UnifyResult unifyResult = new UnifyResult();
        unifyResult.setData(body);
        return unifyResult;
    }
}
