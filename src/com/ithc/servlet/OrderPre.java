package com.ithc.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ithc.bean.Order;
import com.ithc.bean.OrderDetail;
import com.ithc.service.OrderDetailService;
import com.ithc.service.OrderService;
import com.ithc.service.impl.OrderDetailServiceImpl;
import com.ithc.service.impl.OrderServiceImpl;

@WebServlet("/orderPre")
public class OrderPre extends HttpServlet{
	private OrderService orderService = new OrderServiceImpl();
	private OrderDetailService orderDetailService = new OrderDetailServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String oid = req.getParameter("oid");
		Order order = orderService.selectAll(oid);
		System.out.println("idpay="+order.getIdPay());
		ArrayList<OrderDetail> menu = orderDetailService.selectByOrderId(oid);
		HttpSession session = req.getSession();
		session.setAttribute("order", order);
		session.setAttribute("menu", menu);
		req.getRequestDispatcher("/WEB-INF/views/order/orderPre.jsp").forward(req, resp);
	}

}
