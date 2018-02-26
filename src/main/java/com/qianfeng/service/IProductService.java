package com.qianfeng.service;

import java.util.List;

import com.qianfeng.pojo.po.Product;

public interface IProductService {

	List<Product> selectProducts();

	Product selectProductById(Product product);

}
