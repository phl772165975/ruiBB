package com.ithc.dao;

import java.util.ArrayList;

import com.ithc.bean.Table;

public interface TableDao {

	ArrayList<Table> selectAll(int pageNow);

	int selectRowSize();

	int delete(String id);

	Table selectAll(String id);

	int updateTable(String id, String orderid, String num, String description, String flag);

	int addTable(String num);

	ArrayList<Table> selectOrderId();

	int addOrderId(String id, int oId);

	void updateOrderId(String tid);

}
