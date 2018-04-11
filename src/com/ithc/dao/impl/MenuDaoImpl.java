package com.ithc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ithc.bean.Menu;
import com.ithc.bean.MenuType;
import com.ithc.bean.Page;
import com.ithc.dao.MenuDao;
import com.ithc.util.DBUtils;

public class MenuDaoImpl implements MenuDao {

	private Connection conn = DBUtils.getConn();
	private int code;
	@Override
	public int selectRowSize() {
		try {
			PreparedStatement ps = conn.prepareStatement("select count(*) from menutbl");
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				code = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return code;
	}
	@Override
	public ArrayList<Menu> selectAll(int pageNow) {
		ArrayList<Menu> list = new ArrayList<Menu>();
		try {
			PreparedStatement ps = conn.prepareStatement("select m.id,t.name,m.name,price,pic,remark from menutbl m,menutypetbl t where m.typeid=t.id order by id limit ?,?");
			ps.setInt(1, (pageNow-1)*Page.PAGE_SIZE);
			ps.setInt(2, Page.PAGE_SIZE);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Menu menu= new Menu();
				menu.setMid(rs.getInt(1));
				MenuType menuType = new MenuType();
				menuType.setName(rs.getString(2));
				menu.setMenuType(menuType);
				menu.setName(rs.getString(3));
				menu.setPrice(rs.getString(4));
				menu.setPic(rs.getString(5));
				menu.setRemark(rs.getString(6));
				list.add(menu);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public int delete(String id) {
		try {
			PreparedStatement ps = conn.prepareStatement("delete  from menutbl where id=?");
			ps.setString(1, id);
			code = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return code;
	}
	@Override
	public Menu selectMenu(String id) {
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT m.id AS m_id,t.id AS t_id,t.name,m.name,price,pic,remark from menutbl m,menutypetbl t where m.typeid=t.id and m.id=?");
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				Menu menu = new Menu();
				MenuType menuType = new MenuType();
				menu.setMid(rs.getInt(1));
				menuType.setTid(rs.getInt(2));
				menuType.setName(rs.getString(3));
				menu.setMenuType(menuType);
				menu.setName(rs.getString(4));
				menu.setPrice(rs.getString(5));
				menu.setPic(rs.getString(6));
				menu.setRemark(rs.getString(7));
				return menu;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public int updateMenu(int id, String name, String price, int menutype_id, String remark, String photo) {
		try {
			PreparedStatement ps = conn.prepareStatement("update menutbl set typeid=?,name=?,price=?,pic=?,remark=? where id=?");
			System.out.println("tid="+id);
			ps.setInt(1, menutype_id);
			ps.setString(2, name);
			ps.setString(3, price);
			ps.setString(4, photo);
			ps.setString(5, remark);
			ps.setInt(6, id);
			code = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return code;
	}
	@Override
	public int addMenu(String name, String price, int menutype_id, String remark, String photo) {
		try {
			PreparedStatement ps = conn.prepareStatement("insert into menutbl values(null,?,?,?,?,?)");
			ps.setInt(1, menutype_id);
			ps.setString(2, name);
			ps.setString(3, price);
			ps.setString(4, photo);
			ps.setString(5, remark);
			code = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return code;
	}
	@Override
	public ArrayList<Menu> selectMenuName() {
		ArrayList<Menu> list = new ArrayList<Menu>();
		try {
			PreparedStatement ps = conn.prepareStatement("select id,name from menutbl");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Menu menu = new Menu();
				menu.setMid(rs.getInt(1));
				menu.setName(rs.getString(2));
				list.add(menu);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
