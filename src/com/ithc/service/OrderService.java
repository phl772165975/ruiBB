package com.ithc.service;

import java.util.ArrayList;

import com.ithc.bean.Order;
import com.ithc.bean.OrderDetail;

public interface OrderService {

	ArrayList<Order> selectAll(int pageNow);

	ArrayList<OrderDetail> selectSumPrice(int pageNow);

	int selectRowSize();

	int addOrder(String id, String personNum, String idpay, String remark);

	int selectOrderIdByTableId(String id);

	int delete(String oid);

	Order selectAll(String oid);

	int updatePay(String oid, int pay);

}
