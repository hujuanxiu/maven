package com.yc.spring.bean;

import java.util.List;

public class Person {

	private String name;
	private String id;
	private int age;
	private List<String> killeds;
	
	private int height;
	//绰号
	private String alisa;
	
	
	public List<String> getKilleds() {
		return killeds;
	}
	public void setKilleds(List<String> killeds) {
		this.killeds = killeds;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public String getAlisa() {
		return alisa;
	}
	public void setAlisa(String alisa) {
		this.alisa = alisa;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
