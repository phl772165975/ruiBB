package com.ithc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ithc.bean.User;
import com.ithc.service.UserService;
import com.ithc.service.impl.UserServericeImpl;

@WebServlet("/userManager")
public class UserManager extends HttpServlet{
	private UserService userService = new UserServericeImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		User user = userService.selectAll(id);
		HttpSession session = req.getSession();
		session.removeAttribute("user");
		session.setAttribute("user", user);
		req.getRequestDispatcher("/WEB-INF/views/grzx.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

}
