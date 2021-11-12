package com.tensquare.article.service.impl;

import com.tensquare.article.client.NoticeClient;
import com.tensquare.article.dao.ArticleDao;
import com.tensquare.article.pojo.Article;
import com.tensquare.article.pojo.Notice;
import com.tensquare.article.service.ArticleService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private NoticeClient noticeClient;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public List<Article> findAll() {
        return articleDao.selectList(null);
    }


    @Override
    public Article findById(String articleId) {
        return articleDao.selectById(articleId);
    }

    @Override
    public Boolean save(Article article) {
        return articleDao.insert(article) > 0;
    }

    public void thumpup(String articleId, String userId) {
        Article article = articleDao.selectById(articleId);
        article.setThumbup(article.getThumbup() + 1);
        articleDao.updateById(article);

        //点赞成功后，需要发送消息给文章作者（点对点消息）
        Notice notice = new Notice();
        // 接收消息用户的ID
        notice.setReceiverId(article.getUserid());
        // 进行操作用户的ID
        notice.setOperatorId(userId);
        // 操作类型（评论，点赞等）
        notice.setAction("publish");
        // 被操作的对象，例如文章，评论等
        notice.setTargetType("article");
        // 被操作对象的id，例如文章的id，评论的id'
        notice.setTargetId(articleId);
        // 通知类型
        notice.setTargetType("user");

        //保存消息
        noticeClient.save(notice);

    }
}
