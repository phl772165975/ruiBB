package com.ithc.service;

import com.ithc.bean.User;

public interface UserService {

	User checkLogin(String username, String password);

	int updatePwd(String id, String password);

	int userRefresh(int id, String username, String name, String gender, int permission, String remark);

	User selectAll(String id);

}
