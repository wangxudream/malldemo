package com.kataer.mall.common.exception;

import com.kataer.mall.common.ErrorCode;

/**
 * @ClassName ApiException
 * @Description: TODO
 * @Author kataer
 * @Date 2021/2/3 22:48
 * @Version V1.0
 **/
public class ApiException extends RuntimeException {
    private ErrorCode errorCode;

    public ApiException(ErrorCode errorCode) {
        super(errorCode.getMsg());
        this.errorCode = errorCode;
    }

    public ApiException(String message) {
        super(message);
    }

    public ApiException(Throwable cause) {
        super(cause);
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
