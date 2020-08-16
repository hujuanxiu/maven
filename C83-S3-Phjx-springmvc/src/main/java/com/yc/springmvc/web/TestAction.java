package com.yc.springmvc.web;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.yc.damai.po.DmUser;

@RestController
@RequestMapping("user")    //可以设置共同的副目录
/**
 * @SessionAttributes 与 @RestController有冲突 所以屏蔽
 * names 用于监控数据模型中出现指定名字的对象
 * types 用户监控数据模型中出现指定类型的对象
 */
//@SessionAttributes(names = "loginedUser",types = Date.class)
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
	
	/**
	 * 地址参数：get请求的参数格式
	 * 标准URL中的参数格式login,do?user=root&pwd=123
	 * 地址参数user/root/123/login.do
	 */
	@RequestMapping("/{user}/{pwd}/login")
	public String login(
			@PathVariable("user") String user,
			@PathVariable() String pwd) {
		return user+"<br>"+pwd;
	}
	
	/**
	 * 会话对象的注入
	 * SpringMVC数据模型  Model 请求过程交互过程中临时保存的对象
	 * @SessionAttributes 将指定对象设置到会话中，加在类上
	 * @RestController 与 @SessionAttributes有冲突
	 * 要在 @RestController 标注的类中给会话添加属性，要通过注入会话对象的方法
	 * @SessionAttribute 从会话中获取一个指定的对象，加在方法参数上
	 * 
	 */
	
	@RequestMapping("/{user}/{pwd}/login.do")
	public String logindo(
			@PathVariable("user") String user,
			@PathVariable() String pwd,
			Model model,
			HttpSession session) {
		
		DmUser du=new DmUser();
		du.setEname(user);
		du.setPassword(pwd);
		//将用户对象添加到数据模型中
		session.setAttribute("loginedUser", du);
		session.setAttribute("now", new Date());
		session.setAttribute("age", 100);
		return du.toString();
	} 
	//验证会话中的值
	@RequestMapping("testlogin")
	public String testLogin(
			@SessionAttribute("loginedUser") DmUser du,
			@SessionAttribute("now") Date date,
			@SessionAttribute(value = "age",required = false) Integer age) {
		return du+"<br>"+date+"<br>"+age;
	}
	
}
