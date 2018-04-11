package com.ithc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ithc.service.OrderService;
import com.ithc.service.impl.OrderServiceImpl;

@WebServlet("/orderAjax")
public class OrderAjax extends HttpServlet{
	private OrderService orderService = new OrderServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String oid = req.getParameter("oid");
		String ipay = req.getParameter("ipay");
		int pay = Integer.parseInt(ipay);
		System.out.println(pay);
		int code = orderService.updatePay(oid,pay);
//		System.out.println("按键事件="+code);
		PrintWriter out = resp.getWriter();
		out.println(code);
	}

}
