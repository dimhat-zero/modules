package com.jianla.exception;

/**
 * @author : zwj
 * @data : 2016/9/21
 */
public class JianlaException extends RuntimeException{

    public JianlaException() {
    }

    public JianlaException(String message) {
        super(message);
    }

    public JianlaException(String message, Throwable cause) {
        super(message, cause);
    }

    public JianlaException(Throwable cause) {
        super(cause);
    }

    public JianlaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
