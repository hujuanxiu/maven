package com.yc.damai.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

import com.yc.damai.po.DmCategory;
import com.yc.damai.po.DmOrderitem;
import com.yc.damai.po.DmOrders;
import com.yc.damai.po.DmProduct;
/**
 * 接口映射
 * @author 风吹来的小仙女
 *
 */
public interface DmOrdersMapper {

	List<DmOrders> selectAll();
	
	
	DmOrders selectById(int id);
	//新增订单
	@Insert("insert into dm_orders values(null,#{total},now(),#{state},#{uid},#{aid})")
	@Options(useGeneratedKeys=true,keyProperty="id",keyColumn="id")
	int insert(DmOrders dos);
}
