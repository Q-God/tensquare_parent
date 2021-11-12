package com.tensquare.notice.client;

import com.tensquare.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @version v1.0
 * @ClassName UserClient
 * @Description TODO
 * @Author Q
 */
@FeignClient("tensquare-user")
public interface UserClient {

    @GetMapping("/user/{userId}")
    public Result findById(@PathVariable String userId);
}
