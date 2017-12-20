package pers.frame4j.security.exception;

/**
 * 认证异常（当非法访问时抛出）
 */
public class AuthcException extends Exception {

    
	private static final long serialVersionUID = 984237275300329473L;

	public AuthcException() {
        super();
    }

    public AuthcException(String message) {
        super(message);
    }

    public AuthcException(String message, Throwable cause) {
        super(message, cause);
    }

    public AuthcException(Throwable cause) {
        super(cause);
    }
}
