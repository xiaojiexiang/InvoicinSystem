package com.qianfeng.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qianfeng.mapper.ProductMapper;
import com.qianfeng.mapper.SaleMapper;
import com.qianfeng.mapper.UserMapper;
import com.qianfeng.pojo.SaleShow;
import com.qianfeng.pojo.po.Product;
import com.qianfeng.pojo.po.Sale;
import com.qianfeng.pojo.po.User;
import com.qianfeng.pojo.vo.PageBean;
import com.qianfeng.service.ISaleService;

@Service
public class SaleServiceImpl implements ISaleService {
	@Autowired
	SaleMapper saleMapper;
	@Autowired
	ProductMapper productMapper;
	@Autowired
	UserMapper userMapper;
	@Override
	public void insertSale(Sale sale) {
		sale.setSaledate(new Date(System.currentTimeMillis()));
		double totalprice = sale.getPrice()*sale.getQuantity();
		sale.setTotalprice(totalprice);
		saleMapper.insertSale(sale);
	}
/*	@Override
	public List<SaleShow> selectSale() {
		List<Sale> saleList = saleMapper.selectSale();
		List<SaleShow> saleShowList = new ArrayList<>();
		for (Sale sale : saleList) {
			SaleShow saleShow = new SaleShow();
			User user = userMapper.selectUserById(sale.getUid());
			Product product = productMapper.selectProductById(sale.getProductId());
			saleShow.setProduct(product);
			saleShow.setUser(user);
			saleShow.setSale(sale);
			saleShowList.add(saleShow);
		}
		return saleShowList;
	}*/
	
	/**
	 * 要想实现分页的功能，就必须获得这五项数据
	 * 当前页	   currentPage
	 * 每页显示的条数    currentCount
	 * 数据总条数	totalCount
	 * 总页数		totalPage
	 * 当前页上的数据     PageData
	 */
	/*@Override
	public PageBean<SaleShow> selectPageBean(PageBean<SaleShow> pageBean,List<SaleShow> saleShowList) {
		Integer currentPageInt = 1;
		if (pageBean.getCurrentPage()!=1&&pageBean.getCurrentPage()!=null) {
			currentPageInt = pageBean.getCurrentPage();
		}
		Integer currentCount = 5;
		Integer totalCount = saleMapper.selectTotalCountSale();
		Integer totalPage = (int) Math.ceil(totalCount/(currentCount*1.0));
		pageBean.setCurrentPage(currentPageInt);
		pageBean.setCurrentCount(currentCount);
		pageBean.setTotalCount(totalCount);
		pageBean.setTotalPage(totalPage);
		pageBean.setPageData(saleShowList);
		return pageBean;
	}*/
	@Override
	public PageBean<SaleShow> selectPageBean(Integer currentPageInt, Integer currentCount,String orderMethod) {
		Integer currentPageIndex = (currentPageInt-1)*currentCount;
		List<Sale> saleList = new ArrayList<>();
		if (orderMethod==null||orderMethod.equals("0")) {
			saleList = saleMapper.selectSale(currentPageIndex,currentCount);
			orderMethod = "0";
		}else if (orderMethod.equals("1")) {
			saleList = saleMapper.selectSaleOrderByTotalprice(currentPageIndex, currentCount);
		}
		List<SaleShow> saleShowList = new ArrayList<>();
		for (Sale sale : saleList) {
			SaleShow saleShow = new SaleShow();
			User user = userMapper.selectUserById(sale.getUid());
			Product product = productMapper.selectProductById(sale.getProductId());
			saleShow.setProduct(product);
			saleShow.setUser(user);
			saleShow.setSale(sale);
			saleShowList.add(saleShow);
		}
		Integer totalCount = saleMapper.selectTotalCountSale();
		Integer totalPage = (int) Math.ceil(totalCount/(currentCount*1.0));
		
		PageBean<SaleShow> pageBean = new PageBean<>();
		pageBean.setCurrentPage(currentPageInt);
		pageBean.setCurrentCount(currentCount);
		pageBean.setTotalCount(totalCount);
		pageBean.setTotalPage(totalPage);
		pageBean.setPageData(saleShowList);
		pageBean.setOrderMethod(orderMethod);
		return pageBean;
	}

}
