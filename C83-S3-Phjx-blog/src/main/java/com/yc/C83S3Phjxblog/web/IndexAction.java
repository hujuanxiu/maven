package com.yc.C83S3Phjxblog.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.yc.C83S3Phjxblog.dao.ArticleMapper;

@Controller
public class IndexAction {
	
	@Resource
	private ArticleMapper am;
	
	
	@GetMapping("/")
	public String index(Model  model,@RequestParam(defaultValue = "1")int page) {
		//在执行查询前，设置分页参数
		//注意：必须是在查询方法执行前调用分页参数设置
		PageHelper.startPage(page, 5);
		model.addAttribute("alist", am.selectByNew());
		return "index";
	}
	@GetMapping("article")
	public String article(int id,Model model) {
		model.addAttribute("article", am.selectById(id));
		return "article";
	}

}
