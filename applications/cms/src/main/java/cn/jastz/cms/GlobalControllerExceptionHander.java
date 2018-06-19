package cn.jastz.cms;

import cn.jastz.cms.exception.UserNotLoginException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author zhiwen
 */
@ControllerAdvice
public class GlobalControllerExceptionHander {

    @ExceptionHandler(UserNotLoginException.class)
    public String handleNotLogin() {
        return "redirect:/login";
    }
}
