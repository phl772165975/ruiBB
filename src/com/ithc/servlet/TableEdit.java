package com.ithc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ithc.bean.Table;
import com.ithc.service.TableService;
import com.ithc.service.impl.TableServiceImpl;

@WebServlet("/tableEdit")
public class TableEdit extends HttpServlet{
	private TableService tableService = new TableServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Table tables = tableService.selectAll(id);
		HttpSession session = req.getSession();
		session.setAttribute("tables", tables);
		req.getRequestDispatcher("/WEB-INF/views/table/tableEdit.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	
}
