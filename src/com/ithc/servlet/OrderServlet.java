package com.ithc.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ithc.bean.Order;
import com.ithc.bean.OrderDetail;
import com.ithc.bean.Page;
import com.ithc.service.OrderService;
import com.ithc.service.impl.OrderServiceImpl;

@WebServlet("/orderServlet")
public class OrderServlet extends HttpServlet{
	private OrderService orderService = new OrderServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Page page = new Page();
		//查询总共有多少行
		int rowSize = orderService.selectRowSize();
		System.out.println("总共有"+rowSize);
		page.setRowSize(rowSize);
		String pageNow1 = req.getParameter("pageNow");
		int pageNow = page.getPageNow();
		if(pageNow1!=null){
			pageNow = Integer.parseInt(pageNow1);
			page.setPageNow(pageNow);
		}
		int pageCount = page.getPageCount();
		ArrayList<OrderDetail> totalPrice = orderService.selectSumPrice(pageNow);
		ArrayList<Order> list = orderService.selectAll(pageNow);
		
		HttpSession session = req.getSession();
		session.setAttribute("list", list);
		session.setAttribute("pageNow", pageNow);
		session.setAttribute("pageCount", pageCount);
		session.setAttribute("totalPrice", totalPrice);
		for (OrderDetail orderDetail : totalPrice) {
//			System.out.println(orderDetail.getOrder().getOid()+":"+orderDetail.getMenu().getPrice());
			System.out.println(orderDetail);
		}
		req.getRequestDispatcher("/WEB-INF/views/order/order.jsp").forward(req, resp);
	}

}
