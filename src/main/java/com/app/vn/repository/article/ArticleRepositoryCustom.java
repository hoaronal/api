package com.app.vn.repository.article;

import java.util.List;



import com.app.vn.common.model.Article;


public interface ArticleRepositoryCustom {
    List<Article> getAllArticles();
    Article getArticleById(long articleId);
    void addArticle(Article article);
    void updateArticle(Article article);
    void deleteArticle(long articleId);
    boolean articleExists(String title, String category);

}
