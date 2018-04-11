package com.ithc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ithc.bean.Menu;
import com.ithc.bean.Order;
import com.ithc.bean.OrderDetail;
import com.ithc.dao.OrderDetailServiceDao;
import com.ithc.util.DBUtils;

public class OrderDetailServiceDaoImpl implements OrderDetailServiceDao {

	private Connection conn = DBUtils.getConn();
	private int code;
	@Override
	public void addorder(String string, int oId) {
		try {
			PreparedStatement ps = conn.prepareStatement("insert into orderdetailtbl values(null,?,?,'1','1')");
			ps.setString(1, string);
			ps.setInt(2, oId);
			code = ps.executeUpdate();
			System.out.println(code);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void delete(String oid) {
		try {
			PreparedStatement ps = conn.prepareStatement("delete from orderdetailtbl where orderID=?");
			ps.setString(1, oid);
			code = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public ArrayList<OrderDetail> selectByOrderId(String oid) {
		ArrayList<OrderDetail> list = new ArrayList<OrderDetail>();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT orderid,price,NAME,m.remark FROM menutbl m,orderdetailtbl od WHERE od.menuid=m.id AND od.orderid=?");
			ps.setString(1, oid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				OrderDetail orderDetail = new OrderDetail();
				Order order = new Order();
				order.setOid(rs.getInt(1));
				orderDetail.setOrder(order);
				Menu menu = new Menu();
				menu.setPrice(rs.getString(2));
				menu.setName(rs.getString(3));
				menu.setRemark(rs.getString(4));
				orderDetail.setMenu(menu);
				list.add(orderDetail);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
