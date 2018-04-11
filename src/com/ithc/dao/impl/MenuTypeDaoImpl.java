package com.ithc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ithc.bean.MenuType;
import com.ithc.dao.MenuTypeDao;
import com.ithc.util.DBUtils;

public class MenuTypeDaoImpl implements MenuTypeDao {

	private Connection conn = DBUtils.getConn();
	@Override
	public ArrayList<MenuType> selectall() {
		ArrayList<MenuType> list = new ArrayList<MenuType>();
		try {
			PreparedStatement ps = conn.prepareStatement("select id,name from menutypetbl");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				MenuType menuType = new MenuType();
				menuType.setTid(rs.getInt(1));
				menuType.setName(rs.getString(2));
				list.add(menuType);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
