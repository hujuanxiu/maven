package com.yc.damai.dao;

import java.util.List;


import com.yc.damai.po.DmCategory;
import com.yc.damai.po.DmOrderitem;
import com.yc.damai.po.DmOrders;
import com.yc.damai.po.DmProduct;
/**
 * 接口映射
 * @author 风吹来的小仙女
 *
 */
public interface DmOrderitemMapper {

	List<DmOrderitem> selectAll();
	
	
	DmOrderitem selectById(int id);
	List<DmOrderitem> selectByOid(int id); 
	
	List<DmOrderitem> selectByIds(int id); 
	//List<DmOrderitem> selectById(int id);
	DmOrderitem selectByOid(DmOrders dor);
	
	//新增订单明细
	int insert(DmOrderitem doi);
}
