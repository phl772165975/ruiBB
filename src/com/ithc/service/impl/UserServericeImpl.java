package com.ithc.service.impl;

import com.ithc.bean.User;
import com.ithc.dao.UserDao;
import com.ithc.dao.impl.UserDaoImpl;
import com.ithc.service.UserService;
import com.ithc.util.Permission;

public class UserServericeImpl implements UserService {
	private UserDao userDao = new UserDaoImpl();
	@Override
	public User checkLogin(String username, String password) {
		int permission = Permission.getPermission();
		return userDao.checkLogin(username,password,permission);
	}
	@Override
	public int updatePwd(String id, String password) {
		return userDao.updatePwd(id,password);
	}
	@Override
	public int userRefresh(int id, String username, String name, String gender, int permission, String remark) {
		return userDao.userRefresh(id,username,name,gender,permission,remark);
	}
	@Override
	public User selectAll(String id) {
		return userDao.selectAll(id);
	}

}
