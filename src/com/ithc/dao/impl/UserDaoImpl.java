package com.ithc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ithc.bean.User;
import com.ithc.dao.UserDao;
import com.ithc.util.DBUtils;

public class UserDaoImpl implements UserDao {

	private Connection conn = DBUtils.getConn();
	private int code;
	@Override
	public User checkLogin(String username, String password, int permission) {
		try {
			PreparedStatement ps = conn.prepareStatement("select id,username"
					+ ",password,name,gender,permission,remark from usertbl "
					+ "where username=? and password=? and permission=?");
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setInt(3, permission);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setPermission(rs.getInt("permission"));
				user.setGender(rs.getString("gender"));
				user.setRemark(rs.getString("remark"));
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	@Override
	public int updatePwd(String id, String password) {
		try {
			PreparedStatement ps = conn.prepareStatement("update usertbl set password=? where id=?");
			ps.setString(1, password);
			ps.setString(2, id);
			code = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return code;
	}
	@Override
	public int userRefresh(int id, String username, String name, String gender, int permission, String remark) {
		try {
			PreparedStatement ps = conn.prepareStatement("update usertbl set username=?,"
					+ "name=?,gender=?,permission=?,remark=? where id=?");
			ps.setString(1, username);
			ps.setString(2, name);
			ps.setString(3, gender);
			ps.setInt(4, permission);
			ps.setString(5, remark);
			ps.setInt(6, id);
			code = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return code;
	}
	@Override
	public User selectAll(String id) {
		try {
			PreparedStatement ps = conn.prepareStatement("select id,username,password,name,gender,permission,remark from usertbl where id=?");
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setGender(rs.getString("gender"));
				user.setPermission(rs.getInt("permission"));
				user.setRemark(rs.getString("remark"));
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
