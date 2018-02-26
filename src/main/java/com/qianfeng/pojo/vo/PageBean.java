package com.qianfeng.pojo.vo;

import java.util.List;


public class PageBean<T> {
	/*
	 * 要想实现分页的功能，就必须获得这五项数据
	 * 当前页	   currentPage
	 * 每页显示的条数    currentCount
	 * 数据总条数	totalCount
	 * 总页数		totalPage
	 * 当前页上的数据     PageData
	 */
	private Integer currentPage;
	private Integer currentCount;
	private Integer totalCount;
	private Integer totalPage;
	private List<T> PageData;
	private String orderMethod;
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getCurrentCount() {
		return currentCount;
	}
	public void setCurrentCount(Integer currentCount) {
		this.currentCount = currentCount;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public List<T> getPageData() {
		return PageData;
	}
	public void setPageData(List<T> pageData) {
		PageData = pageData;
	}
	
	public String getOrderMethod() {
		return orderMethod;
	}
	public void setOrderMethod(String orderMethod) {
		this.orderMethod = orderMethod;
	}
	public PageBean(Integer currentPage, Integer currentCount, Integer totalCount, Integer totalPage,
			List<T> pageData) {
		super();
		this.currentPage = currentPage;
		this.currentCount = currentCount;
		this.totalCount = totalCount;
		this.totalPage = totalPage;
		PageData = pageData;
	}
	public PageBean() {
		super();
	}
	
}
