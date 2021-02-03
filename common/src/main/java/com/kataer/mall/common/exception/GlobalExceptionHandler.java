package com.kataer.mall.common.exception;

import com.kataer.mall.common.ResultBody;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @ClassName GlobalExceptionHandler
 * @Description: 全局异常处理类
 * @Author kataer
 * @Date 2021/2/3 22:59
 * @Version V1.0
 **/
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = ApiException.class)
    public ResultBody handleApiException(ApiException e) {
        return ResultBody.failed(e.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    public ResultBody handleException(Exception e) {
        return ResultBody.failed();
    }

}
