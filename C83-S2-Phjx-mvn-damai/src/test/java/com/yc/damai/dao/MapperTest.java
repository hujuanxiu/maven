package com.yc.damai.dao;

import java.io.IOException;

import java.io.InputStream;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.yc.damai.po.DmCategory;
import com.yc.damai.po.DmOrderitem;
import com.yc.damai.po.DmOrders;
import com.yc.damai.po.DmProduct;

import junit.framework.Assert;

public class MapperTest {

	private SqlSession session;
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
		}catch(IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	@Test
	public  void test() throws IOException {		
		List<DmProduct> list=session.selectList("com.yc.damai.dao.ProductMapper.selectAll");
		
		/**
		 * 使用断言进行结果的判断
		 * true表示的期望值
		 * list.size()>0是实际值
		 */
		Assert.assertEquals(true, list.size()>0);
		for(DmProduct dp:list) {
			System.out.println(dp);
		}
	}
	
	//
	@Test
	public void test2() throws IOException{
		DmCategory dc=new DmCategory();
		dc.setCname("测试分类");
		dc.setPid(1);
		DmCategoryMapper mapper=session.getMapper(DmCategoryMapper.class);
		mapper.insert(dc);
		//session.insert("com.yc.damai.dao.ProductMapper.insert", dc);
		//不commit，会话会在关闭自动回滚
		session.commit();
		session.close();
	}
	
	@Test
	public void test3() throws IOException{
		DmCategory dc=new DmCategory();
		dc.setId(45);
		dc.setCname("修改后的测试分类");
		dc.setPid(1);
		DmCategoryMapper mapper=session.getMapper(DmCategoryMapper.class);
		mapper.update(dc);
		//session.update("com.yc.damai.dao.ProductMapper.update", dc);
		//不commit，会话会在关闭自动回滚
		session.commit();
		session.close();
	}
	
	@Test
	public void test4() throws IOException{
//		DmCategory dc=new DmCategory();
//		dc.setId(44);
//		dc.setCname("修改后的测试分类");
//		dc.setPid(1);
		DmCategoryMapper mapper=session.getMapper(DmCategoryMapper.class);
		mapper.delete(45);
		//session.delete("com.yc.damai.dao.ProductMapper.delete", dc);
		//不commit，会话会在关闭自动回滚
		session.commit();
		session.close();
	}
	
	@Test
	public void test5() throws IOException{
		DmProduct dp=new DmProduct();
		dp.setPname("MAC口红");
		dp.setShopPrice(380.0);
		dp.setMarketPrice(110.0);
		dp.setPdesc("最靓丽的颜色");
		dp.setIsHot(1);
		dp.setCid(7);
		DmProductMapper mapper=session.getMapper(DmProductMapper.class);
		mapper.insertPro(dp);
		//session.insert("com.yc.damai.dao.ProductMapper.insertPro", dp);
		//不commit，会话会在关闭自动回滚
		session.commit();
		session.close();
	}
	
	@Test
	public void test6() throws IOException{
		DmProduct dp=new DmProduct();
		dp.setId(81);
		dp.setPname("MAC口红辣椒色");
		dp.setShopPrice(380.0);
		dp.setMarketPrice(100.0);
		dp.setPdesc("最靓丽的颜色，给你最自信的美丽");
		dp.setIsHot(1);
		dp.setCid(7);
		DmProductMapper mapper=session.getMapper(DmProductMapper.class);
		mapper.updatePro(dp);
		//session.insert("com.yc.damai.dao.ProductMapper.updatePro", dp);
		//不commit，会话会在关闭自动回滚
		session.commit();
		session.close();
	}
	
	@Test
	public void test7() throws IOException{
		DmProduct dp=new DmProduct();
		dp.setId(81);
		DmProductMapper mapper=session.getMapper(DmProductMapper.class);
		mapper.deletePro(dp);
		//session.insert("com.yc.damai.dao.ProductMapper.deletePro", dp);
		//不commit，会话会在关闭自动回滚
		session.commit();
		session.close();
	}
	
	@Test
	public void test8() throws IOException{
		DmProduct dp=new DmProduct();
		dp.setId(78);
		List<DmProduct> list=session.selectList("com.yc.damai.dao.ProductMapper.selectPro",dp);
		Assert.assertEquals(true, list.size()>0);
	}
	
	@Test
	public void test9() throws IOException{
		/**
		 * 1.先查出一个订单明细记录
		 * 2.查出该订单明细对应的商品信息
		 */
//		DmOrderitemMapper dom=session.getMapper(DmOrderitemMapper.class);
//		DmProductMapper dpm=session.getMapper(DmProductMapper.class);
//		DmOrderitem doi=dom.selectById(59);
//		DmProduct dp=dpm.selectById(doi.getPid());
		
		
		/**
		 * 测试驱动开发--》先写好所有的测试代码--》再业务代码
		 */
		DmOrderitemMapper dom=session.getMapper(DmOrderitemMapper.class);
		DmOrderitem doi=dom.selectById(73);
		//java黑科技--》反射--》动态代理技术
		DmProduct dp=doi.getDmProduct();//调用dmProduct属性的get方法
		
		
		
		System.out.println(dp);
		
		session.commit();
		session.close();
	}
	
	

	@Test
	public void test10() throws IOException{
		//查出分类 一对多查询
		DmCategoryMapper mapper=session.getMapper(DmCategoryMapper.class);
		List<DmCategory> dcList=mapper.selectAll();
		System.out.println("======1=======");
		DmCategory dc=dcList.get(1);
		System.out.println("======2=======");
		Assert.assertEquals("鞋靴箱包",dc.getCname());
		System.out.println("======3=======");
		Assert.assertEquals(6,dc.getChildren().size());
	}
	
	@Test
	public void test11() throws IOException{
		DmProductMapper mapper=session.getMapper(DmProductMapper.class);
		System.out.println("==========1==========");
		mapper.selectByObj(null);
		DmProduct dp=new DmProduct();
		System.out.println("==========2==========");
		mapper.selectByObj(dp);
		
		
		dp.setPname("韩版连帽加厚毛衣女外套");
		System.out.println("==========3===========");
		mapper.selectByObj(dp);
		
		dp.setPdesc("双11限量200件，拍完下架，加车享优惠，早下手早发货。。秋冬个性中长款毛衣，美丽和温度同在！限量供应，拒绝撞衫！迫于纱线和人工在不断上涨的双重压力下，产品涨价在即！少量现货出售中，手快有，手慢等哦，赶紧抢哦，绝对高大上。");
		System.out.println("==========4===========");
		mapper.selectByObj(dp);
		
		dp.setIsHot(1);
		System.out.println("==========5===========");
		mapper.selectByObj(dp);
	}
	
	
	@Test
	public void test12() throws IOException{
		//foreach测试
		DmProductMapper mapper=session.getMapper(DmProductMapper.class);
		int[] cids= {1,2,3};
		mapper.selectByCids(cids);
	}
	
	@Test
	public void test13() throws IOException{
		DmProductMapper mapper=session.getMapper(DmProductMapper.class);
		DmProduct dp=new DmProduct();
		//只修改一个字段(market_Price)值
		dp.setId(1);
		dp.setMarketPrice(885d);
		mapper.update(dp);
		//从数据库查出该记录，验证结果
		DmProduct dbdp=mapper.selectById(1);
		Assert.assertEquals((Double)885d, dbdp.getMarketPrice());
		Assert.assertEquals((Double)228d, dbdp.getShopPrice());
		Assert.assertEquals("韩版连帽加厚毛衣女外套", dbdp.getPname());
		
		/**
		 * 更新的时候没设置的值就为Null的解决方案
		 * 1.在Update之前先将数据库中的该记录的值全部查询出来，设置到dp中
		 * 2.动态生成更新sql，只更新不为null的字段
		 *     如果有个字段要改成null值就会出现问题
		 */
	}
	
	
	@Test
	public void test14() throws IOException{
		//一对多查询
		DmOrdersMapper mapper=session.getMapper(DmOrdersMapper.class);
		System.out.println("===============1");
		DmOrders dom=mapper.selectById(91);	
		DmOrderitemMapper doit=session.getMapper(DmOrderitemMapper.class);
		System.out.println("==============2");
		DmOrderitem doi=doit.selectByOid(dom);
		//java黑科技--》反射--》动态代理技术
		System.out.println("==============3");
		DmProduct dp=doi.getDmProduct();
		System.out.println(dp);
		session.commit();
		session.close();
		
	}
	
	@Test
	public void test15() throws IOException{
		DmCategoryMapper mapper=session.getMapper(DmCategoryMapper.class);
		DmCategory dc=mapper.selectById(6);
		DmProductMapper dpr=session.getMapper(DmProductMapper.class);
		List<DmProduct> dp=dpr.selectByCid(dc);
		System.out.println(dp);
	}
	
	
	
	
	
	
}
