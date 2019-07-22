package com.softdev.system.demo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

@Data
@Document(indexName = "article_info", type = "doc")
public class Article {
    @Id
    private Integer id;

    private String title;

    private String text;

    private Date createtime;

    private String author;

}