package com.yc.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.yc.spring.bean.Person;

@Configuration
@ComponentScan("com.yc.spring")
@EnableAspectJAutoProxy   
/* AOP不是spring提供的概念
 * spring对AOP的依赖AspectJ 框架
 *  
 */
public class AOPConfig {

	@Bean("person")  //未指定id，方法名就是id
	public Person getPerson() {
		return new Person();
	}
	
	@Bean
	public Hello getHello() {
		return new Hello();
	}
}

