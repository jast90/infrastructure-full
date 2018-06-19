package cn.jastz.cms.exception;

/**
 * @author zhiwen
 */
public class UserNotLoginException extends RuntimeException {
    public UserNotLoginException(String message) {
        super(message);
    }

    public UserNotLoginException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotLoginException(Throwable cause) {
        super(cause);
    }
}
