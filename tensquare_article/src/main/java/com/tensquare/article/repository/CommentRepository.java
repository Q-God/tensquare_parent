package com.tensquare.article.repository;

import com.tensquare.article.pojo.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CommentRepository extends MongoRepository<Comment, String> {
    /**
     * 根据文章id查询文章评论
     *
     * @param articleId
     * @return
     */
    List<Comment> findByArticleid(String articleId);
}
