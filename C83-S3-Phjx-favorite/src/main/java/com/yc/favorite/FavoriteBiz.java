package com.yc.favorite;

import org.apache.ibatis.session.SqlSession;

import com.yc.favorite.bean.Favorite;
import com.yc.favorite.bean.Tag;
import com.yc.favorite.bean.TagFavorite;
import com.yc.favorite.dao.FavoriteMapper;
import com.yc.favorite.dao.TagFavoriteMapper;
import com.yc.favorite.dao.TagMapper;
import com.yc.favorite.util.MyBatisHelper;

public class FavoriteBiz {

	public void addFavorite(Favorite f) {
		/**
		 * Favorite：
		 * 1淘宝 taobao.com好网站  购物，生活
		 * 2网易 163.com 常用网站    门户，军事，生活
		 * 
		 * TagFavorite(tid,fid)(中间表)
		 * 1  1 
		 * 2  1
		 * 3  2
		 * 4  2
		 * 2  2
		 * 
		 * 
		 * Tag
		 * 1.购物1
		 * 2.生活 2
		 * 3.门户 1
		 * 4.军事 1
		 */
		
			//添加链接到favorite表  Insert
			SqlSession session=MyBatisHelper.openSession();
			FavoriteMapper fm=session.getMapper(FavoriteMapper.class);
			TagMapper tm=session.getMapper(TagMapper.class);
			TagFavoriteMapper tfm=session.getMapper(TagFavoriteMapper.class);
			try {
			fm.insert(f);
			//拆分分类 ftags
			String[] tname=f.getFtags().split("[,，;：]");
			for(String t:tname) {
				Tag tag=new Tag();
				//直接修改分类的 数量
				if(tm.update(t)==0) {
				//   如果返回的结果为0表示没有修改到对应的记录，那么就新增
					
					tag.setTname(t);
					tm.insert(tag);
				}else {
				//   如果返回的结果为1表示修改数量成功
					//并且查询数据对应的tag对象
					tag=tm.selectByName(t);
				}
				
				//根据分类tid和链接的fid向中间表写入记录
				TagFavorite tf=new TagFavorite();
				tf.setTid(tag.getTid());
				tf.setFid(f.getFid());
				tfm.insert(tf);
				session.commit();
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally {
			session.close();
		}
		
	
		
		
	}
}
