package com.jianla.faudit.exception;

import com.jianla.exception.JianlaException;

/**
 * @author : zwj
 * @data : 2016/9/21
 */
public class FauditException extends JianlaException {

    public FauditException() {
    }

    public FauditException(String message) {
        super(message);
    }

    public FauditException(String message, Throwable cause) {
        super(message, cause);
    }

    public FauditException(Throwable cause) {
        super(cause);
    }

    public FauditException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
