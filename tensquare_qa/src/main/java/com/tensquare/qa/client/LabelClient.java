package com.tensquare.qa.client;

import com.tensquare.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "tensquare-base")
public interface LabelClient {
    @GetMapping("/label/{id}")
    Result findById(@PathVariable String id);
}
