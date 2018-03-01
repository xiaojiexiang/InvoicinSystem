package com.qianfeng.service;

import java.util.List;

import com.qianfeng.pojo.SaleShow;
import com.qianfeng.pojo.po.Sale;
import com.qianfeng.pojo.vo.PageBean;

public interface ISaleService {

	void insertSale(Sale sale);

	PageBean<SaleShow> selectPageBean(Integer currentPageInt, Integer currentCount,String orderMethod);

}
