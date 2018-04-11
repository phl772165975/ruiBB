package com.ithc.dao;

import java.util.ArrayList;

import com.ithc.bean.Menu;
import com.ithc.bean.OrderDetail;

public interface OrderDetailServiceDao {

	void addorder(String string, int oId);

	void delete(String oid);

	ArrayList<OrderDetail> selectByOrderId(String oid);

}
