package com.tensquare.notice.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tensquare.notice.pojo.Notice;
import com.tensquare.notice.pojo.NoticeFresh;

/**
 * @version v1.0
 * @ClassName NoticeService
 * @Description TODO
 * @Author Q
 */
public interface NoticeService {

    Notice selectById(String id);

    Page<Notice> selectByPage(Notice notice, Integer page, Integer size);

    void save(Notice notice);

    void updateById(Notice notice);

    Page<NoticeFresh> freshPage(String userId, Integer page, Integer size);

    void freshDelete(NoticeFresh noticeFresh);
}
