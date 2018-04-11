package com.ithc.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ithc.bean.Menu;
import com.ithc.bean.MenuType;
import com.ithc.bean.Page;
import com.ithc.service.MenuService;
import com.ithc.service.MenuTypeService;
import com.ithc.service.impl.MenuServiceImpl;
import com.ithc.service.impl.MenuTypeServiceImpl;

@WebServlet("/menuUpdate")
public class MenuUpdate extends HttpServlet{
	private MenuService menuService = new MenuServiceImpl();
	private MenuTypeService menuTypeService = new MenuTypeServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Page page = new Page();
		//查询总共有多少行
		int rowSize = menuService.selectRowSize();
		page.setRowSize(rowSize);
		String pageNow1 = req.getParameter("pageNow");
		int pageNow = page.getPageNow();
		if(pageNow1!=null){
			pageNow = Integer.parseInt(pageNow1);
			page.setPageNow(pageNow);
		}
		int pageCount = page.getPageCount();
		ArrayList<Menu> menu = menuService.selectAll(pageNow);
		System.out.println(menu + "...");
		HttpSession session = req.getSession();
		session.setAttribute("menu", menu);
		String id = req.getParameter("id");
		System.out.println("id="+id);
		Menu menus = menuService.selectMenu(id);
		System.out.println(menus);
		ArrayList<MenuType> menuType = menuTypeService.selectall();
		session.setAttribute("menus", menus);
		session.setAttribute("menuType", menuType);
		session.setAttribute("pageNow", pageNow);
//		resp.sendRedirect("/WEB-INF/views/menu/menuEdit.jsp?pageNow="+pageNow);
		req.getRequestDispatcher("/WEB-INF/views/menu/menuEdit.jsp").forward(req, resp);
	}
	
}
