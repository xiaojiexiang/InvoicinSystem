package com.qianfeng.mapper;

import java.util.List;

import com.qianfeng.pojo.po.Product;

public interface ProductMapper {

	List<Product> selectProducts();

	Product selectProductById(Integer productId);

}
