package com.tensquare.article.controller;

import com.tensquare.article.pojo.Article;
import com.tensquare.article.service.ArticleService;
import com.tensquare.entity.Result;
import com.tensquare.entity.StatusCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Api(tags = "文章接口")
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @ApiOperation(value = "查询全部文章")
    @GetMapping()
    public Result findAll() {
        List<Article> list = articleService.findAll();
        Map<String, Object> map = new HashMap<>();
        map.put("list", list);
        return new Result.Builder().flag(true).code(StatusCode.OK).message("查询成功").data(map).build();
    }

    @ApiOperation(value = "通过id查询文章")
    @GetMapping("/{articleId}")
    public Result findById(@PathVariable String articleId) {
        Article article = articleService.findById(articleId);
        return new Result.Builder().flag(true).code(StatusCode.OK).message("查询成功").data(article).build();
    }

    @ApiOperation(value = "新增文章")
    @PostMapping("/save")
    public Result save(@RequestBody Article article) {
        Boolean b = articleService.save(article);
        return new Result.Builder().flag(true).code(StatusCode.OK).message("添加成功").build();
    }

    @ApiOperation(value = "测试异常")
    @RequestMapping(value = "/exception", method = RequestMethod.GET)
    public Result exception() throws Exception {
        throw new Exception("测试统一异常处理");
    }

}
