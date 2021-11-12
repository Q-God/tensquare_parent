package com.tensquare.article.service;

import com.tensquare.article.pojo.Comment;

import java.util.List;

public interface CommentService {

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    Comment findById(String id);

    /**
     * 查询所有
     *
     * @return
     */
    List<Comment> findAll();

    /**
     * 新增
     *
     * @param comment
     */
    void save(Comment comment);

    /**
     * 修改
     *
     * @param comment
     */
    void updateById(Comment comment);

    /**
     * 通过id删除
     *
     * @param id
     */
    void deleteById(String id);

    /**
     * 根据文章id查询文章评论
     *
     * @param articleId
     */
    List<Comment> findByArticleId(String articleId);

    /**
     * 点赞业务逻辑
     * @param id
     */
    void thumbup(String id);
}
