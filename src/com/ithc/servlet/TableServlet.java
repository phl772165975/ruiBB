package com.ithc.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ithc.bean.Page;
import com.ithc.bean.Table;
import com.ithc.service.TableService;
import com.ithc.service.impl.TableServiceImpl;

@WebServlet("/tableServlet")
public class TableServlet extends HttpServlet{
	private TableService tableService = new TableServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Page page = new Page();
		//查询总共有多少行
		int rowSize = tableService.selectRowSize();
		page.setRowSize(rowSize);
		String pageNow1 = req.getParameter("pageNow");
		int pageNow = page.getPageNow();
		if(pageNow1!=null){
			pageNow = Integer.parseInt(pageNow1);
			page.setPageNow(pageNow);
		}
		int pageCount = page.getPageCount();
		ArrayList<Table> table = tableService.selectAll(pageNow);
		HttpSession session = req.getSession();
		session.setAttribute("table", table);
		session.setAttribute("pageNow", pageNow);
		session.setAttribute("pageCount", pageCount);
		req.getRequestDispatcher("WEB-INF/views/table/table.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

}
