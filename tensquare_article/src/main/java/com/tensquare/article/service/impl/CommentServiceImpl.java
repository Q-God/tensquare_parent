package com.tensquare.article.service.impl;

import com.tensquare.article.pojo.Comment;
import com.tensquare.article.repository.CommentRepository;
import com.tensquare.article.service.CommentService;
import com.tensquare.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @version v1.0
 * @ClassName CommentServiceImpl
 * @Description TODO
 * @Author Q
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private CommentRepository commentRepository;

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    @Override
    public Comment findById(String id) {
        return commentRepository.findById(id).get();
    }

    /**
     * 查询所有
     *
     * @return
     */
    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    /**
     * 新增
     *
     * @param comment
     */
    @Override
    public void save(Comment comment) {
        //生成id Snowflake算法
        String id = idWorker.nextId() + "";
        comment.set_id(id);

        //初始化点赞数据，发布时间等
        comment.setPublishdate(new Date());
        comment.setThumbup(0);

        commentRepository.save(comment);
    }

    /**
     * 修改
     *
     * @param comment
     */
    @Override
    public void updateById(Comment comment) {
        //使用的是MongoRepository的方法
        //其中save方法，主键如果存在，执行修改，如果不存在执行新增
        commentRepository.save(comment);
    }

    /**
     * 通过id删除
     *
     * @param id
     */
    @Override
    public void deleteById(String id) {
        commentRepository.deleteById(id);
    }

    /**
     * 根据文章id查询文章评论
     *
     * @param articleId
     */
    @Override
    public List<Comment> findByArticleId(String articleId) {
        return commentRepository.findByArticleid(articleId);
    }

    /**
     * 点赞业务逻辑
     *
     * @param id
     */
    @Override
    public void thumbup(String id) {
//        //先根据Id查询出评论
//        Comment comment = commentRepository.findById(id).get();
//        //修改点赞数
//        comment.setThumbup(comment.getThumbup() + 1);
//        //更新点赞数
//        commentRepository.save(comment);

        //优化后
        Query query = new Query();

        query.addCriteria(Criteria.where("_id").is(id));

        //修改条件
        Update update = new Update();
        //在原来基础上+1
        update.inc("thumbup", 1);
        mongoTemplate.updateFirst(query, update, "comment");
    }
}
