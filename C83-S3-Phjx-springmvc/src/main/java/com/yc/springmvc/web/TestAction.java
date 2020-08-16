package com.yc.springmvc.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")    //可以设置共同的副目录
public class TestAction {

	@RequestMapping("?/add")
	//user/a/add   user/b/add  ?表示任意一个字符
	public String add() {
		return "add";
	}
	
	@RequestMapping("*/mod")
	//user/a/mod   user/abc/mod  *表示1到n个任意字符
	public String mod() {
		return "mod";
	}
	
	@RequestMapping("**/select")
	//user/a/select  user/a/b/select  user/a/b/c/select
	//  **表示任意的中间的目录
	public String select() {
		return "select";
	}
	
	
}
