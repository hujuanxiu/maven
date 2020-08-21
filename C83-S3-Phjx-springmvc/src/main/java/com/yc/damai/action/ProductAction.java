package com.yc.damai.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.damai.dao.DmProductMapper;
import com.yc.damai.po.DmProduct;

@RestController("pAction")
public class ProductAction {

	@Resource
	private DmProductMapper pm;
	
	/**
	 * Model==》数据模型==》Map集合可以替代Model
	 * 返回Model必须是页面跳转方式才可以
	 * 如果是ajax通过参数注入的Map或Model，里面会默认设置一个视图名
	 *       导致错误，ajax方式不能设置视图名
	 * @param dp
	 * @param m
	 * @return
	 */
//	@GetMapping(path = "product.do",params = "op=query")
	@RequestMapping(path = "product.do",params = "op=query")
	public Map<String, Object> query(DmProduct dp) {
//		dp.setIsHot(1);
		Map<String, Object> m=new HashMap<String, Object>();
		m.put("list", pm.selectByHot());
		return m;
	}
}
