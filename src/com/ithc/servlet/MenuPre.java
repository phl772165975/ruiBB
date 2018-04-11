package com.ithc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ithc.bean.Menu;
import com.ithc.service.MenuService;
import com.ithc.service.impl.MenuServiceImpl;

@WebServlet("/menuPre")
public class MenuPre extends HttpServlet{
	private MenuService menuService = new MenuServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mid = req.getParameter("id");
		Menu model = menuService.selectMenu(mid);
		HttpSession session = req.getSession();
		session.setAttribute("model", model);
		req.getRequestDispatcher("/WEB-INF/views/menu/menuPre.jsp").forward(req, resp);
//		resp.sendRedirect("/WEB-INF/views/menu/menuPre.jsp");
	}
	
}
