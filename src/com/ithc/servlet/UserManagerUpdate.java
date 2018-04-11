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

@WebServlet("/userManagerUpdate")
public class UserManagerUpdate extends HttpServlet{
	private UserService userService = new UserServericeImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		String tid = req.getParameter("id");
		int id = Integer.parseInt(tid);
		String username = req.getParameter("username");
		String name = req.getParameter("name");
		String gender = req.getParameter("gender");
		String tpermission = req.getParameter("permission");
		int permission = Integer.parseInt(tpermission);
		String remark = req.getParameter("remark");
		
		int code = userService.userRefresh(id,username,name,gender,permission,remark);
		if(code==1){
			resp.sendRedirect("userManager?id="+id);
		}
	}

}
