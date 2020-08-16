package com.yc.springmvc.web;

import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
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
	
	@RequestMapping("**/head")
	public String head(@RequestHeader() String accept,
			@RequestHeader(value = "Connection",required = true)String conn) {
		return accept+"<br>"+conn;
	}
	
	//获取cookie的值，要先在浏览器设置cookie
	//document.cookie
	@RequestMapping("**/cookie")
	public String cookie(@CookieValue String user,
			             @CookieValue String age,
			             @RequestHeader String cookie) {
		return user+"<br>"+age+"<br>"+cookie;
	}
	

	/**
	 * 请求对象，响应，会话
	 * 添加servlet依赖
	 * 应用上下文对象不能注入
	 * 
	 */
	@RequestMapping("**/servlet")
	public String servlet(HttpServletRequest request,
			HttpServletResponse response,
			HttpSession session,
			InputStream in,
			OutputStream out) {
		return ""+request+"<br>"+response+"<br>"+session+"<br>"+in+"<br>"+out;
	}
	
}
