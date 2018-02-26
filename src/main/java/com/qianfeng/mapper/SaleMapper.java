package com.qianfeng.mapper;

import java.util.List;

import com.qianfeng.pojo.po.Sale;

public interface SaleMapper {

	void insertSale(Sale sale);

	List<Sale> selectSale(Integer currentPageIndex,Integer currentCount);
	
	List<Sale> selectSaleOrderByTotalprice(Integer currentPageIndex,Integer currentCount);
	
	Integer selectTotalCountSale();


}
