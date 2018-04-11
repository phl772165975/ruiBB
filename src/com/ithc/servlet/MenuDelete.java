package com.ithc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ithc.service.MenuService;
import com.ithc.service.impl.MenuServiceImpl;

@WebServlet("/menuDelete")
public class MenuDelete extends HttpServlet{
	private MenuService menuService = new MenuServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String pageNow = req.getParameter("pageNow");
		System.out.println(id);
		int code = menuService.delete(id);
		if(code==1){
			resp.sendRedirect("menuServlet?pageNow="+pageNow);
		}else{
			resp.sendRedirect("menuServlet?pageNow="+pageNow);
		}
	}
	
}
