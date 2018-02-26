package com.qianfeng.pojo;


import com.qianfeng.pojo.po.Product;
import com.qianfeng.pojo.po.Sale;
import com.qianfeng.pojo.po.User;

public class SaleShow {
	private Sale sale;
	private User user;
	private Product product;
	public Sale getSale() {
		return sale;
	}
	public void setSale(Sale sale) {
		this.sale = sale;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
}
