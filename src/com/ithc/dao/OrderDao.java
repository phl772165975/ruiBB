package com.ithc.dao;

import java.util.ArrayList;

import com.ithc.bean.Order;
import com.ithc.bean.OrderDetail;

public interface OrderDao {

	ArrayList<Order> selectAll(int pageNow);

	int selectRowSize();

	int addOrder(String id, String personNum, String idpay, String remark);

	int selectOrderIdByTableId(String id);

	ArrayList<OrderDetail> selectSumPrice(int pageNow);

	int delete(String oid);

	Order selectAll(String oid);

	int updatePay(String oid, int pay);

}
