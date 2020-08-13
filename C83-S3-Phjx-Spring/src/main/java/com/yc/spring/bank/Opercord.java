package com.yc.spring.bank;

import java.sql.Timestamp;
import java.util.Date;

public class Opercord implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer accountid;
	private Double opmoney;
	private Double charge;
	private Timestamp optime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAccountid() {
		return accountid;
	}
	public void setAccountid(Integer accountid) {
		this.accountid = accountid;
	}
	public Double getOpmoney() {
		return opmoney;
	}
	public void setOpmoney(Double opmoney) {
		this.opmoney = opmoney;
	}
	public Double getCharge() {
		return charge;
	}
	public void setCharge(Double charge) {
		this.charge = charge;
	}
	public Timestamp getOptime() {
		return optime;
	}
	public void setOptime(Timestamp optime) {
		this.optime = optime;
	}
	
	
	
}
