package com.ithc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ithc.service.TableService;
import com.ithc.service.impl.TableServiceImpl;

@WebServlet("/tableUpdate")
public class TableUpdate extends HttpServlet{
	private TableService tableService = new TableServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		String orderid = req.getParameter("ord_id");
		String num = req.getParameter("num");
		String description = req.getParameter("description");
		String flag = req.getParameter("flag");
		int code = tableService.updateTable(id,orderid,num,description,flag);
		if(code==1){
			resp.sendRedirect("tableEdit?id="+id);
		}
	}
	
}
