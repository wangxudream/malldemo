package com.kataer.mall.common;

/**
 * @Description: 状态码枚举类
 * @Author kataer
 * @Date 2021/1/25 22:59
 **/
public enum ResultCode implements ErrorCode {
    SUCCESS(200L, "操作成功"),
    FAILED(500L, "操作失败"),
    VALIDATE_FAILED(404L, "参数检验失败"),
    UNAUTHORIZED(401L, "暂未登录或token已经过期"),
    FORBIDDEN(403L, "没有相关权限");
    private Long code;
    private String msg;

    private ResultCode(Long code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Long getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
