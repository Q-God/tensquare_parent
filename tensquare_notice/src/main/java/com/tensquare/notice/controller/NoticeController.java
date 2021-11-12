package com.tensquare.notice.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tensquare.entity.PageResult;
import com.tensquare.entity.Result;
import com.tensquare.entity.StatusCode;
import com.tensquare.notice.pojo.Notice;
import com.tensquare.notice.pojo.NoticeFresh;
import com.tensquare.notice.service.NoticeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @version v1.0
 * @ClassName NoticeController
 * @Description TODO
 * @Author Q
 */
@Api("notice")
@RestController
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @ApiOperation("根据id查询消息通知")
    @GetMapping("/{id}")
    public Result selectById(@PathVariable String id) {
        Notice notice = noticeService.selectById(id);
        return new Result.Builder().flag(true).code(StatusCode.OK).message("查询成功").data(notice).build();
    }

    @ApiOperation("根据条件分页查询消息通知")
    @PostMapping("/search/{page}/{size}")
    public Result selectByPage(@RequestBody Notice notice,
                               @PathVariable int page,
                               @PathVariable int size) {
        Page<Notice> noticePage = noticeService.selectByPage(notice, page, size);
        PageResult<Notice> pageResult = new PageResult<>(noticePage.getTotal(), noticePage.getRecords());
        return new Result.Builder().flag(true).code(StatusCode.OK).message("查询成功").data(pageResult).build();
    }

    @ApiOperation("新增通知")
    @PostMapping
    public Result save(@RequestBody Notice notice) {
        noticeService.save(notice);
        return new Result.Builder().flag(true).code(StatusCode.OK).message("添加成功").build();
    }

    @ApiOperation("修改通知")
    @PutMapping
    public Result updateById(@RequestBody Notice notice) {
        noticeService.updateById(notice);
        return new Result.Builder().flag(true).code(StatusCode.OK).message("修改成功").build();
    }

    @ApiOperation("根据用户id查询该用户的待推送消息")
    @GetMapping("/fresh/{userId}/{page}/{size}")
    public Result freshPage(@PathVariable String userId,
                            @PathVariable int page,
                            @PathVariable int size) {
        Page<NoticeFresh> noticeFreshPage = noticeService.freshPage(userId, page, size);

        PageResult<NoticeFresh> pageResult = new PageResult<>(noticeFreshPage.getTotal(), noticeFreshPage.getRecords());
        return new Result.Builder().flag(true).code(StatusCode.OK).message("查询成功").data(pageResult).build();
    }

    @ApiOperation(" 删除待推送消息")
    @DeleteMapping("/fresh")
    public Result freshDelete(@RequestBody NoticeFresh noticeFresh) {
        noticeService.freshDelete(noticeFresh);
        return new Result.Builder().flag(true).code(StatusCode.OK).message("删除成功").build();
    }
}
