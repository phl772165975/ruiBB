package com.ithc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ithc.bean.Page;
import com.ithc.bean.Table;
import com.ithc.dao.TableDao;
import com.ithc.util.DBUtils;

public class TableDaoImpl implements TableDao {

	private Connection conn = DBUtils.getConn();
	private int code;
	@Override
	public ArrayList<Table> selectAll(int pageNow) {
		ArrayList<Table> list = new ArrayList<Table>();
		try {
			PreparedStatement ps = conn.prepareStatement("select id,Ord_id,num,flag,description from tabletbl order by id limit ?,?");
			ps.setInt(1, (pageNow-1)*Page.PAGE_SIZE);
			ps.setInt(2, Page.PAGE_SIZE);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Table table = new Table();
				table.setId(rs.getInt("id"));
				table.setOrd_id(rs.getInt("Ord_id"));
				table.setNum(rs.getString("num"));
				table.setFlag(rs.getString("flag"));
				table.setDescription(rs.getString("description"));
				list.add(table);
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
			PreparedStatement ps = conn.prepareStatement("select count(*) from tabletbl");
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
	public int delete(String id) {
		try {
			PreparedStatement ps = conn.prepareStatement("delete  from tabletbl where id=?");
			ps.setString(1, id);
			code = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return code;
	}
	@Override
	public Table selectAll(String id) {
		try {
			PreparedStatement ps = conn.prepareStatement("select id,Ord_id,num,flag,description from tabletbl where id=? order by id ");
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Table table = new Table();
				table.setId(rs.getInt("id"));
				table.setOrd_id(rs.getInt("Ord_id"));
				table.setNum(rs.getString("num"));
				table.setFlag(rs.getString("flag"));
				table.setDescription(rs.getString("description"));
				return table;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public int updateTable(String id, String orderid, String num, String description, String flag) {
		try {
			PreparedStatement ps = conn.prepareStatement("update tabletbl set Ord_id=?,num=?,description=?,flag=? where id=?");
			ps.setString(1, orderid);
			ps.setString(2, num);
			ps.setString(3, description);
			ps.setString(4, flag);
			ps.setString(5, id);
			code = ps.executeUpdate();
			return code;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public int addTable(String num) {
		try {
			PreparedStatement ps = conn.prepareStatement("insert into tabletbl (num)value(?)");
			ps.setString(1, num);
			code = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return code;
	}
	@Override
	public ArrayList<Table> selectOrderId() {
		ArrayList<Table> list = new ArrayList<Table>();
		try {
			PreparedStatement ps = conn.prepareStatement("select id from tabletbl where ord_id=0");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Table table = new Table();
				table.setId(rs.getInt(1));
				list.add(table);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public int addOrderId(String id, int oId) {
		try {
			PreparedStatement ps = conn.prepareStatement("UPDATE tabletbl SET Ord_id=? WHERE id=?");
			ps.setInt(1, oId);
			ps.setString(2, id);
			code = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return code;
	}
	@Override
	public void updateOrderId(String tid) {
		try {
			PreparedStatement ps = conn.prepareStatement("UPDATE tabletbl SET Ord_id='0' WHERE id=?");
			ps.setString(1, tid);
			code = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
