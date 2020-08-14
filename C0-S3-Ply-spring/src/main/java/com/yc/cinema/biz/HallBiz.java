package com.yc.cinema.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.cinema.dao.HallDao;

@Service
public class HallBiz {
	
	@Resource
	private MovieBiz mbiz;
	
	@Resource
	private HallDao hdao;

	public MovieBiz getMbiz() {
		return mbiz;
	}

	public void setMbiz(MovieBiz mbiz) {
		this.mbiz = mbiz;
	}

	public HallDao getHdao() {
		return hdao;
	}

	public void setHdao(HallDao hdao) {
		this.hdao = hdao;
	}
	
}
