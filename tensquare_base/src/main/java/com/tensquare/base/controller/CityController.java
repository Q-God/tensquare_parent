package com.tensquare.base.controller;

import com.netflix.discovery.converters.Auto;
import com.tensquare.base.pojo.City;
import com.tensquare.base.service.CityService;
import com.tensquare.entity.Result;
import com.tensquare.entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @version v1.0
 * @ClassName CityController
 * @Description TODO
 * @Author Q
 */
@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityService cityService;

    public Result findAll() {
        List<City> cityList = cityService.;
        return new Result.Builder().flag(true).code(StatusCode.OK).data()
    }
}
