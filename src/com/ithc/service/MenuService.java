package com.ithc.service;

import java.util.ArrayList;

import com.ithc.bean.Menu;

public interface MenuService {

	int selectRowSize();

	ArrayList<Menu> selectAll(int pageNow);

	int delete(String id);

	Menu selectMenu(String id);

	int updateMenu(int id, String name, String price, int menutype_id, String remark, String photo);

	int addMenu(String name, String price, int menutype_id, String remark, String photo);

	ArrayList<Menu> selectMenuName();


}
