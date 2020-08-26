package com.yc.C83S3Phjxblog.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor{

	/**
	 * 是在请求到控制器之前执行，返回false之前终止方法
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//判断当前是否登录
				if(request.getSession().getAttribute("loginedUser")==null) {
					//根据当前的请求的方式返回不同的结果
					//判断当前是页面跳转还是ajax请求
					String accept=request.getHeader("Accept");
					if(accept.startsWith("application/json")) {
						//ajax请求
						response.setContentType("application/json;charset=utf-8");
						response.getWriter().append("{code:0,msg:'请先登录系统'}");
					}else {
						//页面跳转请求
						response.setContentType("text/html;charset=utf-8");
						response.sendRedirect("/?mustLogin");
						returnJson(response,"{\"code\":0,\"msg\":\"请先登录!\"}");
					}
					return false;
				}
				//正常的业务执行返回true
				return true;
	}
	
	
	/*返回客户端数据*/
    private void returnJson(HttpServletResponse response, String json) throws Exception{
        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        try {
            writer = response.getWriter();
            writer.print(json);
 
        } catch (IOException e) {
        } finally {
            if (writer != null)
                writer.close();
        }
    }

	

}
