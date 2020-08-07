package com.yc.favorite.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.favorite.FavoriteBiz;
import com.yc.favorite.bean.Favorite;

@WebServlet("/fav.do")
public class FavoriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
		
		response.setCharacterEncoding("utf-8");
		
		request.setCharacterEncoding("utf-8");
		FavoriteBiz fb=new FavoriteBiz();
		Favorite f=new Favorite();
		String flabel=request.getParameter("flabel");
		String furl=request.getParameter("furl");
		String fdesc=request.getParameter("fdesc");
		String ftags=request.getParameter("ftags");
		f.setFlabel(flabel);
		f.setFurl(furl);
		f.setFdesc(fdesc);
		f.setFtags(ftags);
		fb.addFavorite(f);
		response.getWriter().append("添加成功");
		
	}

	

}
