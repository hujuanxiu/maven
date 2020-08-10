package com.yc.spring;

public class Hello {

	public void sayHello() {
		System.out.println("hello world");
	}
	//无参数的构造方法
	public Hello() {
		System.out.println("======无参数的构造方法=========");
	}
	//有参数的构造方法
    public Hello(int a) {
		System.out.println("======有参数的构造方法=========");

	}
    
    public void init() {
		System.out.println("========hello被创建===========");
	}
    
    public void destory() {
		System.out.println("========hello被销毁============");
	}
}
