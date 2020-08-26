package com.yc.C83S3Phjxblog.dao;

import org.apache.ibatis.annotations.Select;

import com.yc.C83S3Phjxblog.bean.Category;

public interface CategoryMapper {
	
	@Select("select * from category where id=#{id}")
	public Category selectById(int id);

}
