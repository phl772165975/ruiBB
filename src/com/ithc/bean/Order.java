package com.ithc.bean;

import java.util.ArrayList;

public class Order {
	private int oid;
	private Table table;
	private String orderTime;
	private int userId;
	private int personNum;
	private int idPay;
	private String oremark;
	private ArrayList<OrderDetail> orderDetail;
	
	
	public ArrayList<OrderDetail> getOrderDetail() {
		return orderDetail;
	}
	public void setOrderDetail(ArrayList<OrderDetail> orderDetail) {
		this.orderDetail = orderDetail;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public Table getTable() {
		return table;
	}
	public void setTable(Table table) {
		this.table = table;
	}
	public String getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getPersonNum() {
		return personNum;
	}
	public void setPersonNum(int personNum) {
		this.personNum = personNum;
	}
	public int getIdPay() {
		return idPay;
	}
	public void setIdPay(int idPay) {
		this.idPay = idPay;
	}
	public String getOremark() {
		return oremark;
	}
	public void setOremark(String oremark) {
		this.oremark = oremark;
	}
	@Override
	public String toString() {
		return "Order [oid=" + oid + ", table=" + table + ", orderTime=" + orderTime + ", userId=" + userId
				+ ", personNum=" + personNum + ", idPay=" + idPay + ", oremark=" + oremark + "]";
	}
	public Order() {
	}
	
}
