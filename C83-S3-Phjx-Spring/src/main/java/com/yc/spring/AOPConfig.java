package com.yc.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.yc.spring")
@EnableAspectJAutoProxy   
/* AOP不是spring提供的概念
 * spring对AOP的依赖AspectJ 框架
 *  
 */
public class AOPConfig {

}
