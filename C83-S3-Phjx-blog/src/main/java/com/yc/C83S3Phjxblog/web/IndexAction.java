package com.yc.C83S3Phjxblog.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yc.C83S3Phjxblog.dao.ArticleMapper;

@Controller
public class IndexAction {
	
	@Resource
	private ArticleMapper am;
	
	
	@GetMapping("/")
	public String index(Model  model) {
		
		model.addAttribute("alist", am.selectByNew());
		return "index";
	}

}
