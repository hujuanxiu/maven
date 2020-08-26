package com.yc.C83S3Phjxblog.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.C83S3Phjxblog.bean.Article;
import com.yc.C83S3Phjxblog.dao.ArticleMapper;

@Service
public class ArticleBiz {
	
	@Resource
	private ArticleMapper aMapper;
	
	public int create(Article article) {
		
		return aMapper.insert(article);
	}

}
