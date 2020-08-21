package com.yc.C83S3PhjxSpringBoot.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.yc.C83S3PhjxSpringBoot.damai.po.DmProduct;
import com.yc.C83S3PhjxSpringBoot.dao.ProductMapper;

@Controller
//默认情况下，有方法返回值都被解析成视图
//template目录下的文件
public class IndexAction {

	@Resource
	ProductMapper pm;
	
	
	@GetMapping("index.do")
	public String index(Model m) {
		
		//查询热销商品
		List<DmProduct> hlist=pm.selectByHot();
		
		//查询热卖商品
		List<DmProduct> mlist=pm.selectBymale();
		
		
		//推送给页面
		m.addAttribute("hlist",hlist);
		
		m.addAttribute("mlist",mlist);
		
		return "index";
		//springmvc-->会将返回视图名 前：template+视图名+后缀
	}
}
