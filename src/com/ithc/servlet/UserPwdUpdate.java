package com.ithc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ithc.service.UserService;
import com.ithc.service.impl.UserServericeImpl;

@WebServlet("/userPwdUpdate")
public class UserPwdUpdate extends HttpServlet{
	private UserService userService = new UserServericeImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		String id = req.getParameter("id");
		String password = req.getParameter("password1");
		
		int code = userService.updatePwd(id,password);
		if(code==1){
			out.println("<script language='javascript'>alert('密码修改成功请重新登录');window.location='index.jsp';</script>");
		}
	}

}
