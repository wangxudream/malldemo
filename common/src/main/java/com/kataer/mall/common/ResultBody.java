package com.kataer.mall.common;

/**
 * @Description:返回对象
 * @Author kataer
 * @Date 2021/1/25 22:55
 **/
public class ResultBody<T> {
    private long code;
    private String message;
    private T data;


    protected ResultBody() {
    }

    protected ResultBody(long code, String message) {
        this(code, message, null);
    }

    protected ResultBody(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }


    public static <T> ResultBody<T> success(T data) {
        return new ResultBody<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMsg(), data);
    }

    public static <T> ResultBody<T> success(String message, T data) {
        return new ResultBody<>(ResultCode.SUCCESS.getCode(), message, data);
    }

    public static ResultBody failed() {
        return failed(ResultCode.FAILED);
    }

    public static ResultBody failed(ResultCode code) {
        return new ResultBody(code.getCode(), code.getMsg());
    }

    public static ResultBody failed(String message) {
        return new ResultBody(ResultCode.FAILED.getCode(), message);
    }

    public static ResultBody validateFailed() {
        return failed(ResultCode.VALIDATE_FAILED);
    }

    public static ResultBody forbidden() {
        return failed(ResultCode.FORBIDDEN);
    }

    public static ResultBody unauthorized() {
        return failed(ResultCode.UNAUTHORIZED);
    }


    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
