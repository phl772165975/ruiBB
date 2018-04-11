package com.ithc.service.impl;

import java.util.ArrayList;

import com.ithc.bean.OrderDetail;
import com.ithc.dao.OrderDetailServiceDao;
import com.ithc.dao.impl.OrderDetailServiceDaoImpl;
import com.ithc.service.OrderDetailService;

public class OrderDetailServiceImpl implements OrderDetailService {
	private OrderDetailServiceDao orderDetailServiceDao = new OrderDetailServiceDaoImpl();
	@Override
	public void addorder(String string, int oId) {
		orderDetailServiceDao.addorder(string,oId);
	}
	@Override
	public void delete(String oid) {
		orderDetailServiceDao.delete(oid);
	}
	@Override
	public ArrayList<OrderDetail> selectByOrderId(String oid) {
		return orderDetailServiceDao.selectByOrderId(oid);
	}

}
