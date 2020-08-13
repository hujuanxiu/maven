package com.yc.spring;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.apache.ibatis.annotations.Insert;

import com.yc.spring.dao.UserDao;

//mybatis的会话对象
public class SqlSession {

	public static void main(String[] args) {
		SqlSession session=new SqlSession();
		UserDao ud=session.getMaper(UserDao.class);
		ud.insert(null);
	}
	
	
	/**
	 * 泛型方法：你输入的什么类型，返回的就是什么类型对象
	 * 根据输入的接口，返回接口代理对象
	 * 
	 * 
	 * mybatis动态代理，没有目标对象 session.getMapper(User.class)
	 * @param <M>
	 * @param cls
	 * @return
	 */
	public <M> M getMaper(Class<M> cls) {
		@SuppressWarnings("unchecked")
		M ret=(M) Proxy.newProxyInstance(cls.getClassLoader(), 
				new Class[] {cls}, 
				new InvocationHandler() {
					
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						
						Insert insert=method.getAnnotation(Insert.class);
						if(insert!=null) {
							//使用DBHelper执行该语句
							System.out.println("执行:"+insert.value()[0]);
							if(method.getReturnType()!=null) {
								//根据方法的返回结果，将DBHelper的执行结果返回
								if(method.getReturnType().equals(Integer.class)) {
									
								}
							}
							
						}
						return null;
					}
				});
		
		
		return ret;
	}
	
}
