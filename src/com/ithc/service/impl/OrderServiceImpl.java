package com.ithc.service.impl;

import java.util.ArrayList;

import com.ithc.bean.Order;
import com.ithc.bean.OrderDetail;
import com.ithc.dao.OrderDao;
import com.ithc.dao.impl.OrderDaoImpl;
import com.ithc.service.OrderService;

public class OrderServiceImpl implements OrderService {
	private OrderDao orderDao = new OrderDaoImpl();
	@Override
	public ArrayList<Order> selectAll(int pageNow) {
		return orderDao.selectAll(pageNow);
	}
	@Override
	public ArrayList<OrderDetail> selectSumPrice(int pageNow) {
		return orderDao.selectSumPrice(pageNow);
	}
	@Override
	public int selectRowSize() {
		return orderDao.selectRowSize();
	}
	@Override
	public int addOrder(String id, String personNum, String idpay, String remark) {
		return orderDao.addOrder(id,personNum,idpay,remark);
	}
	@Override
	public int selectOrderIdByTableId(String id) {
		return orderDao.selectOrderIdByTableId(id);
	}
	@Override
	public int delete(String oid) {
		return orderDao.delete(oid);
	}
	@Override
	public Order selectAll(String oid) {
		return orderDao.selectAll(oid);
	}
	@Override
	public int updatePay(String oid, int pay) {
		// TODO Auto-generated method stub
		return orderDao.updatePay(oid,pay);
	}

}
