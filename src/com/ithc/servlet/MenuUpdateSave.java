package com.ithc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ithc.service.MenuService;
import com.ithc.service.impl.MenuServiceImpl;

@WebServlet("/menuUpdateSave")
public class MenuUpdateSave extends HttpServlet{
	private MenuService menuService = new MenuServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sid = req.getParameter("tid");
		int id = Integer.parseInt(sid);
		String pageNow = req.getParameter("pageNow");
		String name = req.getParameter("name");
		String price = req.getParameter("price");
		String menutype_sid = req.getParameter("menuType.id");
		int menutype_id = Integer.parseInt(menutype_sid);
		String remark = req.getParameter("remark");
		String photo = req.getParameter("photo");
		System.out.println(photo);
		System.out.println("tid+"+id);
		int code = menuService.updateMenu(id,name,price,menutype_id,remark,photo);
		System.out.println(code);
		HttpSession session = req.getSession();
		if(code==1){
			session.setAttribute("updMenu", "yes");
			resp.sendRedirect("menuUpdate?id="+id+"&pageNow="+pageNow);
//			req.getRequestDispatcher("menuUpdate").forward(req, resp);
		}
	}
}
