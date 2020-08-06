package com.yc.favorite.bean;

import java.io.Serializable;

public class Tag implements Serializable{

	private static final long serialVersionUID=1L;
	
	private Integer tid;
	private String tname;
	private String tcount;
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getTcount() {
		return tcount;
	}
	public void setTcount(String tcount) {
		this.tcount = tcount;
	}
	@Override
	public String toString() {
		return "tag [tid=" + tid + ", tname=" + tname + ", tcount=" + tcount + "]";
	}
	
	
	
	
	
}
