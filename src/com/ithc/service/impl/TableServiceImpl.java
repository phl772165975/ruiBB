package com.ithc.service.impl;

import java.util.ArrayList;

import com.ithc.bean.Table;
import com.ithc.dao.TableDao;
import com.ithc.dao.impl.TableDaoImpl;
import com.ithc.service.TableService;

public class TableServiceImpl implements TableService {
	private TableDao tableDao = new TableDaoImpl();
	@Override
	public int selectRowSize() {
		// TODO Auto-generated method stub
		return tableDao.selectRowSize();
	}
	@Override
	public ArrayList<Table> selectAll(int pageNow) {
		return tableDao.selectAll(pageNow);
	}
	@Override
	public int delete(String id) {
		return tableDao.delete(id);
	}
	@Override
	public Table selectAll(String id) {
		return tableDao.selectAll(id);
	}
	@Override
	public int updateTable(String id, String orderid, String num, String description, String flag) {
		return tableDao.updateTable(id,orderid,num,description,flag);
	}
	@Override
	public int addTable(String num) {
		return tableDao.addTable(num);
	}
	@Override
	public ArrayList<Table> selectOrderId() {
		return tableDao.selectOrderId() ;
	}
	@Override
	public int addOrderId(String id, int oId) {
		return tableDao.addOrderId(id,oId);
	}
	@Override
	public void updateOrderId(String tid) {
		tableDao.updateOrderId(tid);
	}

}
