package com.yc.C83S3Phjxblog.web;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.apache.ibatis.annotations.Options;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.yc.C83S3Phjxblog.bean.Article;
import com.yc.C83S3Phjxblog.bean.User;
import com.yc.C83S3Phjxblog.biz.ArticleBiz;
import com.yc.C83S3Phjxblog.dao.ArticleMapper;
import com.yc.C83S3Phjxblog.util.Utils;

@RestController
public class ArticleAction {
	
	@Resource
	private ArticleBiz abiz;
	
	@Resource
	private ArticleMapper am;
	
//	@GetMapping("toAddArticle")
//	public String addArticle() {
//		return "addArticle";
//	}
	
	@GetMapping("article")
	public ModelAndView article(int id,ModelAndView mav) {
		mav.addObject("article", am.selectById(id));
		mav.setViewName("article");
		return mav;
	}
	
	@GetMapping("toAddArticle")
	public ModelAndView addArticle(ModelAndView mav) {
		mav.setViewName("addArticle");
		return mav;
	}
	
	
	@PostMapping("addArticle.do")
	//要在RestController实现页面跳转需要ModelAndView关键字
	//ModelAndView=model+view
	public ModelAndView toAddArticle(@Valid Article a,Errors errors,ModelAndView mav,
			@SessionAttribute("loginedUser") User user) {
		if(errors.hasErrors()) {
			mav.addObject("errors", Utils.asMap(errors));
			mav.addObject("article", a);
			//跳转到addArticle页面
			mav.setViewName("addArticle");
		}else {
			//作者的名字写入文章实体中--》loginedUser
			a.setAuthor(user.getName());
			abiz.create(a);
			//a.id-->有值-->数据库的自增列-->mybatis-->@Options
			mav.setViewName("redirect:article?id="+a.getId());  //未完  展示新添加的文章
		}
		return mav;
	}

}
