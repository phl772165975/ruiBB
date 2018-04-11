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
import com.ithc.bean.Table;
import com.ithc.service.MenuService;
import com.ithc.service.TableService;
import com.ithc.service.impl.MenuServiceImpl;
import com.ithc.service.impl.TableServiceImpl;
@WebServlet("/orderAdd")
public class OrderAdd extends HttpServlet{
	private MenuService menuService = new MenuServiceImpl();
	private TableService tableService = new TableServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<Menu> menu = menuService.selectMenuName();
		ArrayList<Table> oid = tableService.selectOrderId();
		HttpSession session = req.getSession();
		session.setAttribute("menu", menu);
		session.setAttribute("oid", oid);
		System.out.println("menu="+menu);
		for (Menu menu2 : menu) {
			System.out.println(menu2.getName());
		}
//		resp.sendRedirect("/WEB-INF/views/order/orderAdd.jsp");
		req.getRequestDispatcher("/WEB-INF/views/order/orderAdd.jsp").forward(req, resp);
	}

}
