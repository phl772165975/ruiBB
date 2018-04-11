package com.ithc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ithc.bean.Page;
import com.ithc.service.MenuService;
import com.ithc.service.impl.MenuServiceImpl;

@WebServlet("/menuAddSave")
public class MenuAddSave extends HttpServlet{
	private MenuService menuService = new MenuServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int rowSize = menuService.selectRowSize();
		
		Page page = new Page();
		//查询总共有多少行
		page.setRowSize(rowSize);
		int pageCount = page.getPageCount();
		int pageNow = pageCount;
		String name = req.getParameter("name");
		String price = req.getParameter("price");
		String menutypes = req.getParameter("menutypes");
		int menutype_id = Integer.parseInt(menutypes);
		String remark = req.getParameter("remark");
		String photo = req.getParameter("photo");
		System.out.println(photo);
		int code = menuService.addMenu(name,price,menutype_id,remark,photo);
		System.out.println(code);
		HttpSession session = req.getSession();
		if(code!=1){
			session.setAttribute("menuAdd", "no");
		}else{
			resp.sendRedirect("menuServlet?pageNow="+pageNow);
		}
	}
}
