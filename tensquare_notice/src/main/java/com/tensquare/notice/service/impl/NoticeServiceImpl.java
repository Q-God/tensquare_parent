package com.tensquare.notice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tensquare.entity.Result;
import com.tensquare.notice.client.ArticleClient;
import com.tensquare.notice.client.UserClient;
import com.tensquare.notice.dao.NoticeDao;
import com.tensquare.notice.dao.NoticeFreshDao;
import com.tensquare.notice.pojo.Notice;
import com.tensquare.notice.pojo.NoticeFresh;
import com.tensquare.notice.service.NoticeService;
import com.tensquare.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;

/**
 * @version v1.0
 * @ClassName NoticeServiceImpl
 * @Description TODO
 * @Author Q
 */
@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeDao noticeDao;

    @Autowired
    private NoticeFreshDao noticeFreshDao;

    @Autowired
    private UserClient userClient;

    @Autowired
    private ArticleClient articleClient;

    @Autowired
    private IdWorker idWorker;

    //完善消息
    private void getInfo(Notice notice) {
        Result userResult = userClient.findById(notice.getOperatorId());
        HashMap userMap = (HashMap) userResult.getData();
        //设置操作者用户昵称到消息通知中
        notice.setOperatorName(userMap.get("nickname").toString());
        //查询对象名称
        Result articleResult = articleClient.findById(notice.getTargetId());
        HashMap articleMap = (HashMap) articleResult.getData();
        //设置对象名称到消息通知中
        notice.setTargetName(articleMap.get("title").toString());

    }

    @Override
    public Notice selectById(String id) {
        Notice notice = noticeDao.selectById(id);
        getInfo(notice);
        return notice;
    }

    @Override
    public Page<Notice> selectByPage(Notice notice, Integer page, Integer size) {
        //封装Page对象
        Page<Notice> p = new Page<>(page, size);

        //执行分页查询·
        Page<Notice> pages = noticeDao.selectPage(p, new QueryWrapper<>(notice));
        pages.getRecords().stream().forEach(this::getInfo);
        return pages;
    }

    @Override
    public void save(Notice notice) {
        //设置初始值
        //设置状态 0表示未读  1表示已读
        notice.setState("0");
        notice.setCreatetime(new Date());
        //使用分布式Id生成器，生成id
        String noticeId = idWorker.nextId() + "";
        notice.setId(noticeId);
        noticeDao.insert(notice);
        //待推送消息入库，新消息提醒
        NoticeFresh noticeFresh = new NoticeFresh();
        noticeFresh.setNoticeId(noticeId);
        //待通知用户的id
        noticeFresh.setUserId(notice.getReceiverId());
        noticeFreshDao.insert(noticeFresh);
    }

    @Override
    public void updateById(Notice notice) {
        noticeDao.updateById(notice);
    }

    @Override
    public Page<NoticeFresh> freshPage(String userId, Integer page, Integer size) {
        //查询条件
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("userId", userId);

        //创建分页对象
        Page<NoticeFresh> p = new Page<>(page, size);

        Page pages = noticeFreshDao.selectPage(p, wrapper);
        return pages;
    }

    @Override
    public void freshDelete(NoticeFresh noticeFresh) {
        noticeFreshDao.delete(new QueryWrapper<>(noticeFresh));
    }
}
