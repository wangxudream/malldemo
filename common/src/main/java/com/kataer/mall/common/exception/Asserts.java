package com.kataer.mall.common.exception;

import com.kataer.mall.common.ErrorCode;

/**
 * @ClassName Asserts
 * @Description: 断言处理类，用于抛出各种API异常
 * @Author kataer
 * @Date 2021/2/3 23:25
 * @Version V1.0
 **/
public class Asserts {
    public static void filed(String message) {
        throw new ApiException(message);
    }

    public static void filed(ErrorCode errorCode) {
        throw new ApiException(errorCode);
    }
}
