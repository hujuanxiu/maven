package com.yc.damai.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.yc.damai.po.DmCategory;
/**
 * 接口映射
 * @author 风吹来的小仙女
 *
 */
public interface DmCategoryMapper {

	@Select("select * from dm_category")
	@Results({
		@Result(property = "children",
				column = "id",
				many = @Many(
				select = "selectChildren"
				))
	})
	List<DmCategory> selectAll();
	
	@Select("select * from dm_category where pid=#{id}")
	List<DmCategory> selectChildren(int id);
	
	
	
	DmCategory selectById(int id);
	
	@Insert("insert into dm_category values(null,#{cname},#{pid})")
	int insert(DmCategory dc);
	
	@Update("update dm_category set cname=#{cname},pid=#{pid}\r\n" + 
			"  where id=#{id}")
	int update(DmCategory dc);
	
	@Delete("delete from dm_category where id=#{id}")
	int delete(DmCategory dc);

	int delete(int id);
}
