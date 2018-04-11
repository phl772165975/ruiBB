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
import com.ithc.bean.Page;
import com.ithc.bean.Table;
import com.ithc.service.MenuService;
import com.ithc.service.impl.MenuServiceImpl;

@WebServlet("/menuServlet")
public class MenuServlet extends HttpServlet{
	private MenuService menuService = new MenuServiceImpl();
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
		for (Menu menu2 : menu) {
			System.out.println(menu2);
		}
		HttpSession session = req.getSession();
		session.setAttribute("menu", menu);
		session.removeAttribute("pageNow");
		session.removeAttribute("pageCount");
		session.setAttribute("pageNow", pageNow);
		session.setAttribute("pageCount", pageCount);
		req.getRequestDispatcher("/WEB-INF/views/menu/menu.jsp").forward(req, resp);
	}
	
}
