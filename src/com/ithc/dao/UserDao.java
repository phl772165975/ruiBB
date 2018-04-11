package com.ithc.dao;

import com.ithc.bean.User;

public interface UserDao {

	User checkLogin(String username, String password, int permission);

	int updatePwd(String id, String password);

	int userRefresh(int id, String username, String name, String gender, int permission, String remark);

	User selectAll(String id);

}
