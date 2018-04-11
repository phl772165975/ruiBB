package com.ithc.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ithc.bean.MenuType;
import com.ithc.service.MenuTypeService;
import com.ithc.service.impl.MenuTypeServiceImpl;

@WebServlet("/menuAdd")
public class MenuAdd extends HttpServlet{
	private MenuTypeService menuTypeService = new MenuTypeServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<MenuType> menuType = menuTypeService.selectall();
		HttpSession session = req.getSession();
		session.setAttribute("menuType", menuType);
		req.getRequestDispatcher("/WEB-INF/views/menu/menuAdd.jsp").forward(req, resp);
	}
	
}
