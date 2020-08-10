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
	
	private Person friend;
	
	
	public Person() {
		
	}
	
	public Person(String name, int age, String alisa) {
		super();
		this.name = name;
		this.age = age;
		this.alisa = alisa;
	}
	
	public Person getFriend() {
		return friend;
	}
	public void setFriend(Person friend) {
		this.friend = friend;
	}
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
