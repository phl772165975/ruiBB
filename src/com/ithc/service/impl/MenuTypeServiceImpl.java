package com.ithc.service.impl;

import java.util.ArrayList;

import com.ithc.bean.MenuType;
import com.ithc.dao.MenuTypeDao;
import com.ithc.dao.impl.MenuTypeDaoImpl;
import com.ithc.service.MenuTypeService;

public class MenuTypeServiceImpl implements MenuTypeService {
	private MenuTypeDao menuTypeDao = new MenuTypeDaoImpl();
	@Override
	public ArrayList<MenuType> selectall() {
		return menuTypeDao.selectall();
	}

}
