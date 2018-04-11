package com.ithc.bean;

public class Page {
	//当前页
	private int pageNow = 1;
	//总共有多少行
	private int rowSize;
	//总共有多少页
	private int pageCount;
	//每一页显示多少行数据
	public static final int PAGE_SIZE = 3;
	public int getPageNow() {
		return pageNow;
	}
	public void setPageNow(int pageNow) {
		if(pageNow<1)
			pageNow = 1;
		if(pageNow>pageCount)
			pageNow=pageCount;
		this.pageNow = pageNow;
	}
	public int getRowSize() {
		return rowSize;
	}
	public void setRowSize(int rowSize) {
		this.rowSize = rowSize;
	}
	public int getPageCount() {
		if(rowSize<PAGE_SIZE){
			pageCount = 1;
		}else{
			if(rowSize%PAGE_SIZE==0){
				pageCount=rowSize/PAGE_SIZE;
			}else{
				pageCount=(rowSize/PAGE_SIZE)+1;
			}
		}
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	@Override
	public String toString() {
		return "Page [pageNow=" + pageNow + ", rowSize=" + rowSize + ", pageCount=" + pageCount + "]";
	}
	
	
}
