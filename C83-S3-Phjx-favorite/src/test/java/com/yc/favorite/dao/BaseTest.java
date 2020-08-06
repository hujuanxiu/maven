package com.yc.favorite.dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.yc.favorite.FavoriteBiz;
import com.yc.favorite.bean.Favorite;
import com.yc.favorite.bean.Tag;
import com.yc.favorite.bean.TagFavorite;
import com.yc.favorite.util.MyBatisHelper;

public class BaseTest {

	@Test
	public void test1() {
		//构建会话
		SqlSession session=MyBatisHelper.openSession();
		FavoriteMapper fm=session.getMapper(FavoriteMapper.class);
		TagMapper tm=session.getMapper(TagMapper.class);
		TagFavoriteMapper tfm=session.getMapper(TagFavoriteMapper.class);
		
		Favorite f=new Favorite();
		f.setFlabel("淘宝");
		f.setFurl("taobao.com");
		f.setFdesc("购物网站");
		f.setFtags("购物与生活");
		fm.insert(f);
		
		
		Tag t=new Tag();
		t.setTcount("4");
		t.setTname("衬衣");
		tm.insert(t);
		
		
		TagFavorite tf=new TagFavorite();
		tf.setFid(f.getFid());
		tf.setTid(t.getTid());
		tfm.insert(tf);
		
		session.commit();
		session.close();
		
	}
	
	@Test
	public void test2() {
		FavoriteBiz fb=new FavoriteBiz();
		Favorite f=new Favorite();
		f.setFlabel("淘宝");
		f.setFurl("taobao.com");
		f.setFdesc("购物网站");
		f.setFtags("购物,生活");
		fb.addFavorite(f);
	}
	
	@Test
	public void test3() {
		FavoriteBiz fb=new FavoriteBiz();
		Favorite f=new Favorite();
		f.setFlabel("网易");
		f.setFurl("162.com");
		f.setFdesc("多内容网站");
		f.setFtags("门户，军事,生活");
		fb.addFavorite(f);
	}
	
}
