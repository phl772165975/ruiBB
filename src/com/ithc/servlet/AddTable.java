package com.ithc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ithc.service.TableService;
import com.ithc.service.impl.TableServiceImpl;

@WebServlet("/addTable")
public class AddTable extends HttpServlet{
	private TableService tableService = new TableServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String num = req.getParameter("num");
		String pageNow = req.getParameter("pageNow");
		int code = tableService.addTable(num);
		if(code==1){
			HttpSession session = req.getSession();
			session.setAttribute("addtable", "yes");
			resp.sendRedirect("tableServlet?pageNow="+pageNow);
		}
	}
}
