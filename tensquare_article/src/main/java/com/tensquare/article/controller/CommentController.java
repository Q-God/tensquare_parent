package com.tensquare.article.controller;

import com.tensquare.article.pojo.Comment;
import com.tensquare.article.service.CommentService;
import com.tensquare.entity.Result;
import com.tensquare.entity.StatusCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @version v1.0
 * @ClassName CommentController
 * @Description TODO
 * @Author Q
 */
@Api(tags = "评论接口")
@RestController
@RequestMapping("/comment")
@CrossOrigin
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private RedisTemplate redisTemplate;

    @ApiOperation("通过commentId查询评论")
    @GetMapping("/{commentId}")
    public Result findById(
            @ApiParam(name = "commentId", value = "评论ID", required = true)
            @PathVariable String commentId) {
        Comment comment = commentService.findById(commentId);
        //return new Result(true, StatusCode.OK,"查询成功",comment);
        return new Result.Builder().flag(true).code(StatusCode.OK).message("查询成功").data(comment).build();
    }

    @ApiOperation("根据文章id查询文章评论")
    @GetMapping("/article/{articleId}")
    public Result findByArticleId(@PathVariable String articleId) {
        List<Comment> list = commentService.findByArticleId(articleId);
        return new Result.Builder().flag(true).code(StatusCode.OK).message("查询成功").data(list).build();
    }

    @ApiOperation("查询所有评论")
    @GetMapping()
    public Result findAll() {
        List<Comment> list = commentService.findAll();
        return new Result.Builder().flag(true).code(StatusCode.OK).message("查询成功").data(list).build();
    }

    @ApiOperation("新增评论")
    @PostMapping()
    public Result save(@RequestBody Comment comment) {
        commentService.save(comment);
        return new Result.Builder().flag(true).code(StatusCode.OK).message("添加成功").build();
    }


    @ApiOperation("修改评论")
    @PutMapping("/{commentId}")
    public Result updateById(
            @ApiParam(name = "commentId", value = "评论ID", required = true)
            @PathVariable String commentId, @RequestBody Comment comment) {
        //设置评论主键
        comment.set_id(commentId);
        //执行更新操作
        commentService.updateById(comment);
        return new Result.Builder().flag(true).code(StatusCode.OK).message("修改成功").build();
    }

    @ApiOperation("删除评论")
    @DeleteMapping("/{commentId}")
    public Result deleteById(
            @ApiParam(name = "commentId", value = "评论ID", required = true)
            @PathVariable String commentId) {
        commentService.deleteById(commentId);
        return new Result.Builder().flag(true).code(StatusCode.OK).message("删除成功").build();
    }

    @ApiOperation("点赞")
    @PutMapping("/thumbup/{id}")
    public Result thumbup(@PathVariable String id) {

        //模拟用户id
        String userid = "123";

        //在redis缓存中查询该用户是否已经点赞
        Object result = redisTemplate.opsForValue().get("thumbup_" + userid + "_" + id);

        if (result != null) {
            return new Result.Builder().flag(false).code(StatusCode.REMOTEERROR).message("不能重复点赞").build();
        }

        //如果没有记录可进行点赞操作
        commentService.thumbup(id);

        //将点赞记录计入缓存
        redisTemplate.opsForValue().set("thumbup_" + userid + "_" + id, 1);

        return new Result.Builder().flag(true).code(StatusCode.OK).message("点赞成功").build();
    }


}
