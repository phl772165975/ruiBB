package com.ithc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ithc.bean.Menu;
import com.ithc.bean.Order;
import com.ithc.bean.OrderDetail;
import com.ithc.bean.Page;
import com.ithc.bean.Table;
import com.ithc.dao.OrderDao;
import com.ithc.util.DBUtils;

public class OrderDaoImpl implements OrderDao {

	private Connection conn = DBUtils.getConn();
	private int code;
	private Order order;
	@Override
	public ArrayList<Order> selectAll(int pageNow) {
		ArrayList<Order> list = new ArrayList<Order>();
		String sql="";
		try {
			sql="SELECT o.id,o.tableid,o.ordertime,o.idpay FROM ordertbl o,tabletbl t WHERE o.tableid=t.id  AND o.id=t.ord_id order by o.id limit ?,?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, (pageNow-1)*Page.PAGE_SIZE);
			ps.setInt(2, Page.PAGE_SIZE);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				order = new Order();
				order.setOid(rs.getInt(1));
				Table table = new Table();
				table.setId(rs.getInt(2));
				order.setTable(table);
				order.setOrderTime(rs.getString(3));
				order.setIdPay(rs.getInt(4));
				list.add(order);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public ArrayList<OrderDetail> selectSumPrice(int pageNow) {
		ArrayList<OrderDetail> list = new ArrayList<OrderDetail>();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT o.id,SUM(price) "
					+ "FROM menutbl m,orderdetailtbl od,ordertbl o "
					+ "WHERE od.menuid=m.id AND od.orderid=o.id GROUP BY od.orderid limit ?,?");
			ps.setInt(1, (pageNow-1)*Page.PAGE_SIZE);
			ps.setInt(2, Page.PAGE_SIZE);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				OrderDetail orderDetail = new OrderDetail();
				Order order = new Order();
				order.setOid(rs.getInt("id"));
				orderDetail.setOrder(order);
				Menu menu = new Menu();
				menu.setPrice(rs.getString("SUM(price)"));
				orderDetail.setMenu(menu);
				list.add(orderDetail);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public int selectRowSize() {
		try {
			PreparedStatement ps = conn.prepareStatement("select count(*) from ordertbl");
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				code = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return code;
	}
	@Override
	public int addOrder(String id, String personNum, String idpay, String remark) {
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO ordertbl VALUES(NULL,?,NOW(),1,?,?,?)");
			ps.setString(1, id);
			ps.setString(2, personNum);
			ps.setString(3, idpay);
			ps.setString(4, remark);
			code = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return code;
	}
	@Override
	public int selectOrderIdByTableId(String id) {
		try {
			PreparedStatement ps = conn.prepareStatement("select id from ordertbl where tableid=?");
			ps.setString(1, id);
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
	public int delete(String oid) {
		try {
			PreparedStatement ps = conn.prepareStatement("delete  from ordertbl where id=?");
			ps.setString(1, oid);
			code = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return code;
	}
	@Override
	public Order selectAll(String oid) {
		String sql="";
		try {
			sql="SELECT personNum,TableID,OrderTime,idPay,remark FROM ordertbl WHERE id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, oid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Order order = new Order();
				order.setPersonNum(rs.getInt(1));
				Table table = new Table();
				table.setId(rs.getInt(2));
				order.setTable(table);
				order.setOrderTime(rs.getString(3));
				order.setIdPay(rs.getInt(4));
				order.setOremark(rs.getString(5));
				return order;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public int updatePay(String oid, int pay) {
		String sql = null;
		if(pay==1){
			sql="update ordertbl set idpay=0 where id="+oid;
		} 
		if(pay==0){
			sql="update ordertbl set idpay=1 where id="+oid;
		}
		try {
			System.out.println(sql);
			Statement statement = conn.createStatement();
			code = statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return code;
	}

}
