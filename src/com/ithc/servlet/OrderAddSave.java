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

@SuppressWarnings("all")
@WebServlet("/orderAddSave")
public class OrderAddSave extends HttpServlet{
	private OrderService orderService = new OrderServiceImpl();
	private TableService tableService = new TableServiceImpl();
	private OrderDetailService orderDetailService = new OrderDetailServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("tableid");
		String personNum = req.getParameter("personNum");
		String idpay = req.getParameter("idpay");
		String remark = req.getParameter("remark");
		int code = orderService.addOrder(id,personNum,idpay,remark);
		String[] menuname = req.getParameterValues("menuname");
		int OId = orderService.selectOrderIdByTableId(id);
		int flag = tableService.addOrderId(id,OId);
		for (int i = 0; i < menuname.length; i++) {
			System.out.println(menuname[i]);
			orderDetailService.addorder(menuname[i],OId);
		}
		if(code==1){
			resp.sendRedirect("orderAdd");
		}
	}

}
