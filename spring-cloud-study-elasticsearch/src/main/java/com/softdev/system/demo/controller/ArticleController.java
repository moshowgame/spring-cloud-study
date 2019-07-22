package com.softdev.system.demo.controller;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.softdev.system.demo.entity.Article;
import com.softdev.system.demo.repository.ArticleRepository;
import com.softdev.system.demo.util.ApiReturnUtil;

import cn.hutool.core.util.RandomUtil;

import java.util.Date;
import java.util.List;

/**
 *  ElasticSearch控制器
 * @author  zhengkai.blog.csdn.net
 * */
@RestController
public class ArticleController {

	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;

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
	 * ElasticSearch之Search封装查询
	 * @author  zhengkai.blog.csdn.net
	 * @param title   搜索标题
	 * @param pageable page = 第几页参数(第一页是0), value = 每页显示条数
	 */
	@GetMapping("search")
	public Object search(@RequestParam(defaultValue = "SpringBoot") String title, @PageableDefault(page = 0, value = 10) Pageable pageable){
		//以下查询等同于封装了{"query":{"bool":{"must":[{"wildcard":{"title.keyword":{"wildcard":"*SpringBoot*","boost":1}}}],"disable_coord":false,"adjust_pure_negative":true,"boost":1}}}
		//按标题进行模糊查询
		QueryBuilder queryBuilder = QueryBuilders.wildcardQuery("title.keyword", "*SpringBoot*");
		//按照顺序构建builder,bool->must->wildcard ,有了上文的JSON,顺序就很好理解了
		BoolQueryBuilder must = QueryBuilders.boolQuery().must(queryBuilder);
		//封装pageable分页
		Page<Article> queryResult =  articleRepository.search(must,pageable);
		//返回
		return ApiReturnUtil.success(queryResult.getContent());
	}
	/**
	 * ElasticSearch之elasticsearchTemplate查询
	 * @author  zhengkai.blog.csdn.net
	 * @param title   搜索标题
	 */
	@GetMapping("originSearch")
	public Object originSearch(@RequestParam(defaultValue = "SpringBoot") String title) {
		BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
		QueryBuilder queryBuilder = QueryBuilders.wildcardQuery("title.keyword", "*SpringBoot*");
		BoolQueryBuilder must = boolQuery.must(queryBuilder);
		NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
		NativeSearchQuery build = nativeSearchQueryBuilder.withQuery(must).build();
		List<Article> queryForList = elasticsearchTemplate.queryForList(build, Article.class);

		return ApiReturnUtil.success(queryForList);
	}
}