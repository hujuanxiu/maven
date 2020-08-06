package com.yc.favorite.dao;

import org.apache.ibatis.annotations.Insert;

import com.yc.favorite.bean.Favorite;

public interface FavoriteMapper {

	@Insert("insert into favorite values(null,)")
	int insert(Favorite f);
}
