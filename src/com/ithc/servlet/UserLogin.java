package com.ithc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ithc.bean.User;
import com.ithc.service.UserService;
import com.ithc.service.impl.UserServericeImpl;

@WebServlet("/userLogin")
public class UserLogin extends HttpServlet{
	private UserService userService = new UserServericeImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String password = req.getParameter("password");
		HttpSession session = req.getSession();
		User user =(User) session.getAttribute("user");
		PrintWriter out = resp.getWriter();
		System.out.println(user.getPassword());
		if(password.equals(user.getPassword())){
			out.println(1);
		}else{
			out.println(0);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String codeName = req.getParameter("codeName");
		HttpSession session = req.getSession();
		String vCode = (String)session.getAttribute("validateCode");
		User user = userService.checkLogin(username,password);
		if(user!=null){
			System.out.println(user);
			if(codeName.equalsIgnoreCase(vCode)){
				System.out.println("登录成功");
				session.setAttribute("user", user);
				req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);
			}else{
				session.setAttribute("msg", "验证码错误！！！");
				resp.sendRedirect("index.jsp");
			}
		}else{
			session.setAttribute("msg", "用户名或密码错误！！！");
			resp.sendRedirect("index.jsp");
		}
	}
	
}
