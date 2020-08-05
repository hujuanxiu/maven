package com.yc.damai.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.yc.damai.po.DmCategory;
import com.yc.damai.po.DmOrderitem;
import com.yc.damai.po.DmOrders;
import com.yc.damai.po.DmProduct;
/**
 * 接口映射
 * @author 风吹来的小仙女
 *
 */
public interface DmProductMapper {

	/**
	 * @Select 注解会默认使用resultType的映射行为
	 * @return
	 */
	@Select("select * from dm_product")
	//@Results替代<resultMap>  @Result替代<result>
	@Results(id="rmdp",value = {
		@Result(column = "id",property = "id",id=true),
		@Result(column = "market_price",property = "marketPrice"),
		@Result(column = "shop_price",property = "shopPrice"),
		@Result(column = "is_hot",property = "isHot")})
	List<DmProduct> selectAll();
	
	int insertPro(DmProduct dp);
	int updatePro(DmProduct dp);
	int deletePro(DmProduct dp);


	@Select("select * from dm_product where id=#{id}")
	//@ResultMap替代<select>标签的resultMap属性
	@ResultMap("rmdp")
	DmProduct selectById(int id);
	
//	List<DmProduct> selectById(int id);
	
	List<DmProduct> selectByObj(DmProduct dp);
	
	List<DmProduct> selectByCid(DmCategory dc);
	/**
	 * 根据枚举的分类id进行查询
	 * @param cids 存放分类id的数组 0-N
	 * @return
	 * 
	 * mybatis不能识别参数的名称
	 * @Param 用于定义参数的名称
	 */
	List<DmProduct> selectByCids(@Param("cids") int [] cids);
	
	List<DmOrders> selectByIds(@Param("oids") int [] oids);
	
	int update(DmProduct dp);
}
