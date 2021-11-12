package com.tensquare.base.handler;

import com.tensquare.entity.Result;
import com.tensquare.entity.StatusCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @version v1.0
 * @ClassName BaseExceptionHandler
 * @Description TODO
 * @Author Q
 */
@ControllerAdvice
public class BaseExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result error(Exception e) {
        return new Result.Builder().flag(false).code(StatusCode.OK).message(e.getMessage()).build();
    }
}
