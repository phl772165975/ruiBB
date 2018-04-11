package com.ithc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ithc.service.OrderDetailService;
import com.ithc.service.OrderService;
import com.ithc.service.TableService;
import com.ithc.service.impl.OrderDetailServiceImpl;
import com.ithc.service.impl.OrderServiceImpl;
import com.ithc.service.impl.TableServiceImpl;

@WebServlet("/orderDelete")
public class OrderDelete extends HttpServlet{
	private OrderService orderService = new OrderServiceImpl();
	private TableService tableService = new TableServiceImpl();
	private OrderDetailService orderDetailService = new OrderDetailServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String oid = req.getParameter("delid");
		String tid = req.getParameter("tableid");
		String pageNow = req.getParameter("pageNow");
		orderDetailService.delete(oid);
		tableService.updateOrderId(tid);
		int code = orderService.delete(oid);
		if(code==1){
			resp.sendRedirect("orderServlet?pageNow="+pageNow);
			System.out.println("OK");
		}else{
			System.out.println("error");
		}
	}
	
}
