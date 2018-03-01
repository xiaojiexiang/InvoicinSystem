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

	/**
	 *
	 * @param currentPageInt
	 * @param currentCount
	 * @param orderMethod
	 * @return
	 */
	@Override
	public PageBean<SaleShow> selectPageBean(Integer currentPageInt, Integer currentCount,String orderMethod) {

		// 分页查询的起始坐标
		Integer currentPageIndex = (currentPageInt-1)*currentCount;

		// 每页显示的数据
		// 查询结果封装到List集合中,注意这里涉及到两种排序方式(默认排序为0,即orderMethod=null的时候)
		List<Sale> saleList = new ArrayList<>();
		if (orderMethod==null||orderMethod.equals("0")) {
			saleList = saleMapper.selectSale(currentPageIndex,currentCount);
			orderMethod = "0";
		}else if (orderMethod.equals("1")) {
			saleList = saleMapper.selectSaleOrderByTotalprice(currentPageIndex, currentCount);
		}
		//将数据信息整合封装入SaleShow的集合中
		//这里做的比较复杂,由于在持久化的时候,存储的都是部分的代号(外键),
		// 所以要根据外键去查找对应的数据,
		//将其封装到对象中
		List<SaleShow> saleShowList = new ArrayList<>();
		for (Sale sale : saleList) {
			SaleShow saleShow = new SaleShow();
			User user = userMapper.selectUserById(sale.getUid());
			Product product = productMapper.selectProductById(sale.getProductId());
			saleShow.setProduct(product);
			saleShow.setUser(user);
			saleShow.setSale(sale);
			//将封装完成的对象add到List集合中
			saleShowList.add(saleShow);
		}
		//数据的总条数
		Integer totalCount = saleMapper.selectTotalCountSale();
		//根据总条数和每页显示的条数计算出总的页码数
		Integer totalPage = (int) Math.ceil(totalCount/(currentCount*1.0));

		//所有的信息都得到了,剩下的就是封装到bean中,return给上一层
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
