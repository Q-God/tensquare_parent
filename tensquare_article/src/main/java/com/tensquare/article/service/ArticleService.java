package com.tensquare.article.service;

import com.tensquare.article.pojo.Article;

import java.util.List;

public interface ArticleService {
    List<Article> findAll();

    Article findById(String articleId);

    Boolean save(Article article);
}
