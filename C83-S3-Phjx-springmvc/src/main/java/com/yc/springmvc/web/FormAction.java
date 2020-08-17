package com.yc.springmvc.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.damai.po.DmOrders;

@RestController
@RequestMapping("0817")
public class FormAction {

	@RequestMapping("addOrders")
	public DmOrders addOrders(DmOrders dos) {
		return dos;
	}
	
}
