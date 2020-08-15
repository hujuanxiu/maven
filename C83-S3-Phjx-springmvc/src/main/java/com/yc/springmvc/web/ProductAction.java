package com.yc.springmvc.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductAction {

	
	/**
	 * path=value互为同义词
	 * method 定义响应的请求类型，例如：GET，POST，DELETE...
	 * params 定义对参数的限定，例如：a=100(限定请求里面必须有a=100的参数)
	 *                        a(限定请求里面必须有a 的参数)
	 * headers 限定请求头域中的字段值，例如：Cookie
	 * consumes 消费：限定请求内容的类型
	 * produces 产品：限定返回内容的类型
	 * @return
	 */
	@RequestMapping(path = "product.do" ,params = "op=query")
	public String query() {
		return "query";
	}
	
	@RequestMapping(path = "product.do" ,params = "op=add")
	public String add() {
		return "add";
	}
	
	
	
	@RequestMapping(path = "product.do" ,params = "op=mod",method = RequestMethod.GET)
	public String mod() {
		return "mod";
	}
	
	@RequestMapping(path = "product.do" ,params = "op=select")
	public String select() {
		return "select";
	}
	
	
	@RequestMapping(path = "product.do" ,params = "op=mgr",headers = {"Host=localhost","Cookie"})
	public String mgr() {
		return "mgr";
	}
	
}
