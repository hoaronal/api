package com.app.vn.services.article;


import com.app.vn.common.model.Article;
import com.app.vn.repository.article.ArticleRepository;
import com.app.vn.repository.article.ArticleRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepositoryCustom articleDAO;

    public ArticleRepository articleRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository){
        this.articleRepository= articleRepository;
    }

    @Override@Transactional
    public Article getArticleById(int articleId) {
        Article obj = articleDAO.getArticleById(articleId);
        return obj;
    }

    @Override
    @Transactional
    public List<Article> getAllArticles(){
        return articleDAO.getAllArticles();
    }

    @Override
    @Transactional
    public synchronized boolean addArticle(Article article){
        if (articleDAO.articleExists(article.getTitle(), article.getCategory())) {
            return false;
        } else {
            articleDAO.addArticle(article);
            return true;
        }
    }

    @Override
    @Transactional
    public void updateArticle(Article article) {
        articleDAO.updateArticle(article);
        //articleRepository.delete(article);
    }

    @Override
    @Transactional
    public void deleteArticle(int articleId) {
        articleDAO.deleteArticle(articleId);
    }
}
