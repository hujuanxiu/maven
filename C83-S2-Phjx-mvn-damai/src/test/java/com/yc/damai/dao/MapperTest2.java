package com.yc.damai.dao;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.yc.damai.po.DmCategory;
import com.yc.damai.po.DmOrderitem;
import com.yc.damai.po.DmOrders;

public class MapperTest2 {

	private SqlSession session;
	private SqlSession session2;
	//动态块
	{
		try {
			//mybatis配置文件
			String resource="mybatis.xml";
			//读入配置文件
			InputStream inputStream=Resources.getResourceAsStream(resource);
			//构建会话工厂--》23设计模式 工厂模式
			SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
			//开启会话
			session=sqlSessionFactory.openSession();
			session2=sqlSessionFactory.openSession();
		}catch(IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Test
	public void test1() throws IOException{
		DmOrdersMapper dosm=session.getMapper(DmOrdersMapper.class);
		DmOrderitemMapper doim=session.getMapper(DmOrderitemMapper.class);
		
		//生成订单业务
		DmOrderitem doi1=new DmOrderitem();
		doi1.setPid(1);
		doi1.setCount(1);
		doi1.setTotal(100d);
		DmOrderitem doi2=new DmOrderitem();
		doi2.setPid(2);
		doi2.setCount(1);
		doi2.setTotal(200d);
		DmOrders dos=new DmOrders();
		dos.setTotal(300d);
		dos.setAid(1);
		dos.setState(1);
		dos.setUid(1);
		try {
			//写订单表
			dosm.insert(dos);
			/**
			 * 在添加订单明细记录时，必须要获取到订单主表主键值id
			 * Mybatis可以实现在insert的同时获取到数据新生成的id,不需要select
			 */
			doi1.setOid(dos.getId());
			doi2.setOid(dos.getId());
			//写订单明细表
			doim.insert(doi1);
			doim.insert(doi2);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally {
			session.close();
		}
		
		
	}
	
	@Test
	public void test2() throws IOException{
		//foreach测试

		DmProductMapper mapper=session.getMapper(DmProductMapper.class);
		DmProductMapper mapper2=session.getMapper(DmProductMapper.class);
		int[] cids= {1000};
		/**
		 * Cache Hit Ratio [com.yc.damai.dao.DmProductMapper]: 0.0
		 * 缓存命中：当前查询结果在缓存出现的概率
		 */
		mapper.selectByCids(cids);
		//提交
		session.commit();
		//Cache Hit Ratio [com.yc.damai.dao.DmProductMapper]: 0.5    1/2
		mapper2.selectByCids(cids);
		// Cache Hit Ratio [com.yc.damai.dao.DmProductMapper]: 0.6666666666666666   2/3
		mapper2.selectByCids(cids);
	}
	
	@Test
	public void test3() throws IOException{
		DmProductMapper mapper=session.getMapper(DmProductMapper.class);
		mapper.selectById(1);
	}
}
