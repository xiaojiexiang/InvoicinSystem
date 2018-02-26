package com.qianfeng.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qianfeng.pojo.po.Product;
import com.qianfeng.pojo.po.User;
import com.qianfeng.service.IProductService;
import com.qianfeng.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserAction {
	
	@Autowired
	IUserService userService;
	@Autowired
	IProductService productService;
	/**
	 * 跳转到登录页面
	 * @return
	 */
	@RequestMapping("/tologin.do")
	public String toLogin() {
		return "login";
	}
	
	@RequestMapping("/login.do")
	@ResponseBody
	public String login(User user,HttpSession session){
		User findUser = userService.selectUser(user);
		
		if (findUser!=null) {
			session.setAttribute("sessionUser", findUser);
			return "1";
		}else {
			return "0";
		}
	}
	@RequestMapping("/logout.do")
	public String logout(HttpSession session){
		session.removeAttribute("sessionUser");
		return "login";
	}
	@RequestMapping("/toindex.do")
	public String toindex(HttpSession session){
		List<Product> productList = productService.selectProducts();
		session.setAttribute("productList", productList);
		return "index";
	}

	
}
