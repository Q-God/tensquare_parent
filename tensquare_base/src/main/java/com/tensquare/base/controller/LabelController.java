package com.tensquare.base.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tensquare.base.pojo.Label;
import com.tensquare.base.service.LabelService;
import com.tensquare.entity.Result;
import com.tensquare.entity.StatusCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @version v1.0
 * @ClassName LabelController
 * @Description TODO
 * @Author Q
 */
@Api("label接口")
@RestController
@RequestMapping("/label")
public class LabelController {

    @Autowired
    private LabelService labelService;

    @GetMapping
    public Result findAll() {
        List list = labelService.findAll();
        return new Result.Builder().flag(true).code(StatusCode.OK).message("查询成功").data(list).build();
    }

    @ApiOperation("通过id查询")
    @GetMapping("/{id}")
    public Result findById(@ApiParam(name = "id", required = true)
                           @PathVariable String id) {
        Label label = labelService.findById(id);
        return new Result.Builder().flag(true).code(StatusCode.OK).message("查询成功").data(label).build();
    }

    @PostMapping
    public Result add(@RequestBody Label label) {
        labelService.add(label);
        return new Result.Builder().flag(true).code(StatusCode.OK).message("添加成功").build();
    }

    @PutMapping
    public Result update(@RequestBody Label label) {
        labelService.update(label);
        return new Result.Builder().flag(true).code(StatusCode.OK).message("修改成功").build();
    }

    @DeleteMapping
    public Result delete(@RequestBody Label label) {
        labelService.delete(label);

        return new Result.Builder().flag(true).code(StatusCode.OK).message("删除成功").build();
    }
    @ApiOperation("分页查询")
    @PostMapping("/search/{page}/{size}")
    public Result search(@RequestBody Map map, @PathVariable int page, @PathVariable int size) {
        IPage pages = labelService.search(map, page, size);
        return new Result.Builder().flag(true).code(StatusCode.OK).message("查询成功").data(pages).build();
    }

    @GetMapping(value = "/exception")
    @CrossOrigin
    public Result exception() throws Exception {
        throw new Exception("测试统一异常处理");
    }
}
