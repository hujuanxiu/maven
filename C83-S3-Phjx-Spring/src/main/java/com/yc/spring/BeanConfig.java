package com.yc.spring;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.yc.spring.bean.Person;
import com.yc.spring.dao.MySQLUserDao;
import com.yc.spring.dao.OracleUserDao;

/**
 * 注解方式配置IOC容器
 *
 */
@Configuration  //IOC容器配置类的注解
public class BeanConfig {

	//xml中的每一个bean对应java的一个方法，这个方法返回bean对象
	//方法名不限定，Bean注解的name属性对应<bean>的id
	

	@Bean(name = "hello")
	public Hello getHello() {
		return new Hello();
	}
	
	
	/*
	 * @Bean(name = "odao") public OracleUserDao getOracleUserDao() { return new
	 * OracleUserDao(); }
	 * 
	 * @Bean(name = "mdao") public MySQLUserDao getMySQLUserDao() { return new
	 * MySQLUserDao(); }
	 */
	
	@Bean(name = "p1")
	public Person Person1() {
		Person ret=new Person();
		ret.setName("武松");
		ret.setAge(35);
		ret.setKilleds(new ArrayList<String>());
		ret.getKilleds().add("西门庆");
		ret.getKilleds().add("西门庆");
		ret.getKilleds().add("蒋门神");
		ret.getKilleds().add("西门庆");
		ret.getKilleds().add("西门庆");
		return ret;
	}
	
	//静态工厂模式
	@Bean(name = "p5")
	public Person getPerson5() {
		Person p=Person.PersonFactory();
		p.setName("王英");
		return p;
	}
	
	
	/**
	 * 原型模式
	 */
	@Bean("hello1")
	@Scope(value = "prototype") //对应<bean scope="prototype">
	public Hello getHello1() {
		return new Hello();
	}
	
	/**
	 * 懒加载
	 * @return
	 */
	@Bean("hello2")
	@Lazy
	public Hello getHello2() {
		return new Hello();
	}
	
	
	/**
	 * 生命周期
	 */
	@Bean(
		initMethod = "init", 
		destroyMethod = "destory",
		name = "hello3"
		)
	public Hello getHello3() {
		return new Hello();
	}
	
	/**
	 * 自动加载
	 * @return
	 */
	@Bean(name = "p7",
		autowire = Autowire.BY_NAME
			)
	public Person getp7() {
		Person ret=new Person();
		ret.setName("武松");
		ret.setAge(35);
		Person re=new Person();
		re.setName("鲁智深");
		ret.setFriend(re);
		return ret;
	}
	
}
