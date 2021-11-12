package com.tensquare.user.service;

import com.tensquare.user.pojo.User;

public interface UserService {

    /**
     * 登录
     */
    User login(User user);

    /**
     * 通过id查询
     */
    User selectById(String id);


}
