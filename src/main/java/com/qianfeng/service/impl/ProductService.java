package com.qianfeng.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qianfeng.mapper.ProductMapper;
import com.qianfeng.pojo.po.Product;
import com.qianfeng.service.IProductService;
@Service
public class ProductService implements IProductService {
	@Autowired
	ProductMapper productMapper;
	
	@Override
	public List<Product> selectProducts() {
		List<Product> productList = productMapper.selectProducts();
		return productList;
	}

	@Override
	public Product selectProductById(Product product) {
		if (product==null) {
			return null;
		}
		return productMapper.selectProductById(product.getProductId());
	}

}
