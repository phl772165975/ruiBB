package com.ithc.bean;

public class MenuType {
	private int tid;
	private String name;
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "MenuType [tid=" + tid + ", name=" + name + "]";
	}
	
}
