package com.ithc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ithc.service.TableService;
import com.ithc.service.impl.TableServiceImpl;

@WebServlet("/tableDelete")
public class TableDelete extends HttpServlet{
	private TableService tableService = new TableServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String pageNow = req.getParameter("pageNow");
		System.out.println(id);
		int code = tableService.delete(id);
		if(code==1){
			resp.sendRedirect("tableServlet?pageNow="+pageNow);
		}else{
			resp.sendRedirect("tableServlet?pageNow="+pageNow);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

}
