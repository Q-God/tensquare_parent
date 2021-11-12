package com.tensquare.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tensquare.user.dao.UserDao;
import com.tensquare.user.pojo.User;
import com.tensquare.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @version v1.0
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author Q
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 登录
     *
     * @param user
     */
    @Override
    public User login(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>(user);
        return userDao.selectOne(queryWrapper);
    }

    /**
     * 通过id查询
     *
     * @param id
     */
    @Override
    public User selectById(String id) {
        return userDao.selectById(id);
    }
}
