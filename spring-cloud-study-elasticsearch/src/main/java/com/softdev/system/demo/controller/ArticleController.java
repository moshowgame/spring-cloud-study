package com.softdev.system.demo.controller;

import cn.hutool.core.util.RandomUtil;
import com.google.common.collect.Lists;
import com.softdev.system.demo.entity.Article;
import com.softdev.system.demo.repository.ArticleRepository;
import com.softdev.system.demo.util.ApiReturnUtil;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
/**
 *  ElasticSearch之ArtocleController
 * @author  zhengkai.blog.csdn.net
 * */
@RestController
public class ArticleController {

	@Autowired
	private ArticleRepository articleRepository;

	@GetMapping("new")
	public Object newArticle(@RequestParam(defaultValue = "SpringBootElasticSearch") String title, @RequestParam(defaultValue = "`Elasticsearch` 是一个`开源`的`分布式`、`高扩展`、`高实时`的RESTful `搜索和分析引擎`，基于`Lucene`......") String text){
		//构建并保存Article
		Article article = new Article();
		article.setId(RandomUtil.randomInt(10000,99999));
		article.setTitle(title);
		article.setText(text);
		article.setCreatetime(new Date());
		article.setAuthor("zhengkai.blog.csdn.net");
		return ApiReturnUtil.success(article);
	}

	@GetMapping("save")
	public Object save(@RequestParam(defaultValue = "SpringBootElasticSearch") String title, @RequestParam(defaultValue = "`Elasticsearch` 是一个`开源`的`分布式`、`高扩展`、`高实时`的RESTful `搜索和分析引擎`，基于`Lucene`......") String text){
		//构建并保存Article
		Article article = new Article();
		article.setId(RandomUtil.randomInt(10000,99999));
		article.setTitle(title);
		article.setText(text);
		article.setCreatetime(new Date());
		article.setAuthor("zhengkai.blog.csdn.net");
		articleRepository.save(article);
		return ApiReturnUtil.success(article);
	}


	/**
	 * @param title   搜索标题
	 * @param pageable page = 第几页参数, value = 每页显示条数
	 */
	@GetMapping("search")
	public Object search(@RequestParam(defaultValue = "SpringBootElasticSearch") String title, @PageableDefault(page = 1, value = 10) Pageable pageable){
		//按标题进行搜索
		QueryBuilder queryBuilder = QueryBuilders.matchQuery("title", title);
		//封装pageable分页
		Iterable<Article> listIt =  articleRepository.search(queryBuilder,pageable);
		//Iterable转list
		List<Article> list= Lists.newArrayList(listIt);
		return ApiReturnUtil.success(list);
	}

}