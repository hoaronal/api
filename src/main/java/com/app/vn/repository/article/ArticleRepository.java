package com.app.vn.repository.article;

import com.app.vn.common.model.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article,Long> {
}
