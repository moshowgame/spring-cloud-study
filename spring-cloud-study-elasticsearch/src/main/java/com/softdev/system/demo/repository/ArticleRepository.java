package com.softdev.system.demo.repository;

import com.softdev.system.demo.entity.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ArticleRepository extends ElasticsearchRepository<Article, Integer> {

}
