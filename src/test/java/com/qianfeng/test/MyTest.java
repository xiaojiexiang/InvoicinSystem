package com.qianfeng.test;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.qianfeng.pojo.SaleShow;
import com.qianfeng.pojo.po.Product;
import com.qianfeng.pojo.po.Sale;

public class MyTest {
	@Test
	public void test1(){
		System.out.println(new Date(System.currentTimeMillis()));
		
	}
	@Test
	public void test2(){
		List<Sale> sales = new ArrayList<Sale>();
		Sale sale1 = new Sale();
		Sale sale2 = new Sale();
		sale1.setTotalprice(22.1);
		sale1.setQuantity(11);
		sale2.setTotalprice(33.3);
		sale2.setQuantity(33);
		sales.add(sale1);
		sales.add(sale2);
		List<SaleShow> saleShows = new ArrayList<SaleShow>();
		for (Sale sale : sales) {
			SaleShow saleShow = new SaleShow();
			saleShow.setSale(sale);
			saleShows.add(saleShow);
		}
		for (SaleShow saleShow : saleShows) {
			System.out.println(saleShow.getSale().getTotalprice());
		}
	}
}
