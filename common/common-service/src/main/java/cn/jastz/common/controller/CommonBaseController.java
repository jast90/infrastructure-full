package cn.jastz.common.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author zhiwen
 */
public class CommonBaseController {

    protected String getAppId() {
        String appId = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return appId;
    }

    protected Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
}
