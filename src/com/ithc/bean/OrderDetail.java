package com.ithc.bean;

public class OrderDetail {
	private int odid;
	private Menu menu;
	private Order order;
	private int odNum;
	private String odRemark;
	public int getOdid() {
		return odid;
	}
	public void setOdid(int odid) {
		this.odid = odid;
	}
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public int getOdNum() {
		return odNum;
	}
	public void setOdNum(int odNum) {
		this.odNum = odNum;
	}
	public String getOdRemark() {
		return odRemark;
	}
	public void setOdRemark(String odRemark) {
		this.odRemark = odRemark;
	}
	@Override
	public String toString() {
		return "OrderDetail [odid=" + odid + ", menu=" + menu + ", order=" + order + ", odNum=" + odNum + ", odRemark="
				+ odRemark + "]";
	}
	public OrderDetail() {
	}
	
}
