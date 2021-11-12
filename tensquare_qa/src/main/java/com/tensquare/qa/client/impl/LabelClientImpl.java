package com.tensquare.qa.client.impl;

import com.tensquare.entity.Result;
import com.tensquare.entity.StatusCode;
import com.tensquare.qa.client.LabelClient;
import org.springframework.stereotype.Component;

/**
 * @version v1.0
 * @ClassName LabelClientImpl
 * @Description 熔断实现类，当LabelClient接口的某个方法调用异常时会执行熔断类里对应的方法
 * @Author Q
 */
@Component
public class LabelClientImpl implements LabelClient {
    @Override
    public Result findById(String id) {
        return new Result.Builder().flag(false).code(StatusCode.ERROR).message("熔断器启动了").build();
    }
}
