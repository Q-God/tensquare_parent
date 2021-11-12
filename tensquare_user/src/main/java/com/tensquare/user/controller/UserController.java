package com.tensquare.user.controller;

import com.tensquare.entity.Result;
import com.tensquare.entity.StatusCode;
import com.tensquare.user.pojo.User;
import com.tensquare.user.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @version v1.0
 * @ClassName UserController
 * @Description TODO
 * @Author Q
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        User result = userService.login(user);

        if (result != null) {
            return new Result.Builder().flag(true).code(StatusCode.OK).message("登录成功").data(result).build();
        }
        return new Result.Builder().flag(false).code(StatusCode.OK).message("登录失败").build();
    }

    @ApiOperation("通过id查询")
    @GetMapping("/{userId}")
    public Result findById(@PathVariable String userId) {
        User user = userService.selectById(userId);
        return new Result.Builder().flag(true).code(StatusCode.OK).message("查询成功").data(user).build();
    }
}
