package com.yc.spring;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.yc.spring.bank.biz.BankBiz;

@RunWith(SpringRunner.class)
@ContextConfiguration("/jdbc.xml")
public class JdbcTest {
	
	@Resource
	private JdbcTemplate jdbcTemplate;
	@Resource
	private BankBiz bz;

	@Test
	public void test1() {
		jdbcTemplate.update("insert into account values(1,'a',1000)");
	}
	
	@Test
	public void test2() {
		bz.register(2, "a", 400);
	}
	
	@Test
	public void test3() {
		bz.save(1, 500);
	}
	
	
}
