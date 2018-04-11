package com.ithc.bean;

public class Table {
	/*CREATE TABLE `tabletbl` (
			  `id` int(11) NOT NULL,
			  `Ord_id` int(11) DEFAULT NULL,
			  `num` varchar(128) DEFAULT NULL,
			  `flag` varchar(128) DEFAULT NULL,
			  `description` varchar(128) DEFAULT NULL,
			  PRIMARY KEY (`id`)
			) ENGINE=InnoDB DEFAULT CHARSET=utf8*/

	private int id;
	private int ord_id;
	private String num;
	private String flag;
	private String description;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrd_id() {
		return ord_id;
	}
	public void setOrd_id(int ord_id) {
		this.ord_id = ord_id;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Table [id=" + id + ", ord_id=" + ord_id + ", num=" + num + ", flag=" + flag + ", description="
				+ description + "]";
	}
	
	
}
