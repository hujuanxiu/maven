package com.yc.favorite.bean;

import java.io.Serializable;

public class TagFavorite implements Serializable{

	private static final long serialVersionUID=1L;
	
	private Integer tid;
	private String fid;
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	@Override
	public String toString() {
		return "Tagfavorite [tid=" + tid + ", fid=" + fid + "]";
	}
	
	
	
	
	
}
