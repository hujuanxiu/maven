package com.yc.C83S3Phjxblog.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.yc.C83S3Phjxblog.bean.User;

public interface UserMapper {
	
	
	@Insert("insert into user values (null,#{name},#{account},#{pwd},#{phone},#{email},#{head},now(),#{status},#{type})")
	public int insert(User user);
	
	@Select("select * from user where account=#{account} and pwd=#{pwd}")
	public User selectByLogin(User user);
	
	
	@Select("select count(*) from user where account=#{account}")
	public int countByAccount(String account);
	
	
	@Select("select * from user where id=#{id}")
	public User selectById(int id);


}
