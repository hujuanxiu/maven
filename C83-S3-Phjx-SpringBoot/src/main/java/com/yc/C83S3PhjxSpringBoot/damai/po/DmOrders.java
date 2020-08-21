package com.yc.C83S3PhjxSpringBoot.damai.po;

import java.sql.Timestamp;
import java.util.List;

public class DmOrders {
    private Integer id;

    private Double total;

    private Timestamp createtime;

    private Integer state;

    private Integer uid;

    private Integer aid;
    
    private DmOrders dmOrders;

    private List<DmProduct> pList;
    

    public List<DmProduct> getpList() {
		return pList;
	}

	public void setpList(List<DmProduct> pList) {
		this.pList = pList;
	}
    
    public DmOrders getDmOrders() {
		return dmOrders;
	}

	public void setDmOrders(DmOrders dmOrders) {
		this.dmOrders = dmOrders;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }
}