package com.ithc.service.impl;

import java.util.ArrayList;

import com.ithc.bean.Menu;
import com.ithc.dao.MenuDao;
import com.ithc.dao.impl.MenuDaoImpl;
import com.ithc.service.MenuService;

public class MenuServiceImpl implements MenuService {
	private MenuDao menuDao = new MenuDaoImpl();
	@Override
	public int selectRowSize() {
		return menuDao.selectRowSize();
	}
	@Override
	public ArrayList<Menu> selectAll(int pageNow) {
		return menuDao.selectAll(pageNow);
	}
	@Override
	public int delete(String id) {
		return menuDao.delete(id);
	}
	@Override
	public Menu selectMenu(String id) {
		return menuDao.selectMenu(id);
	}
	@Override
	public int updateMenu(int id, String name, String price, int menutype_id, String remark, String photo) {
		return menuDao.updateMenu(id,name,price,menutype_id,remark,photo);
	}
	@Override
	public int addMenu(String name, String price, int menutype_id, String remark, String photo) {
		// TODO Auto-generated method stub
		return menuDao.addMenu(name,price,menutype_id,remark,photo);
	}
	@Override
	public ArrayList<Menu> selectMenuName() {
		return menuDao.selectMenuName();
	}

}
