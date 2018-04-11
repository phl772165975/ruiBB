package com.ithc.bean;

public class Menu {
	private int mid;
	private MenuType menuType;
	private String name;
	private String price;
	private String pic;
	private String remark;
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public MenuType getMenuType() {
		return menuType;
	}
	public void setMenuType(MenuType menuType) {
		this.menuType = menuType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Menu [mid=" + mid + ", menuType=" + menuType + ", name=" + name + ", price=" + price + ", pic=" + pic
				+ ", remark=" + remark + "]";
	}
	
	
}
