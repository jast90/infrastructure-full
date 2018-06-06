package cn.jastz.open.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;


/**
 * @author zhiwen
 */
public class BaseController {
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    protected String getCurrentAppId() {
        String appId = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        logger.debug("Current app id is {}", appId);
        return appId;
    }
}
