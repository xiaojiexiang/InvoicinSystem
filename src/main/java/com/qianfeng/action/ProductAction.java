package com.qianfeng.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qianfeng.pojo.po.Product;
import com.qianfeng.service.IProductService;

@Controller
@RequestMapping("/product")
public class ProductAction {
	@Autowired
	IProductService productService;
	
	@RequestMapping("/toInventory.do")
	public String toInventory(Product product,Model model){
		product = productService.selectProductById(product);
		model.addAttribute("selectProduct", product);
		return "inventory";
	}
}
