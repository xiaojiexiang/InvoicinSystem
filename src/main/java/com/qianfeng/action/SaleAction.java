package com.qianfeng.action;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qianfeng.pojo.SaleShow;
import com.qianfeng.pojo.po.Sale;
import com.qianfeng.pojo.vo.PageBean;
import com.qianfeng.service.IProductService;
import com.qianfeng.service.ISaleService;

@Controller
@RequestMapping("/sale")
public class SaleAction {
	@Autowired
	ISaleService saleService;
	@Autowired
	IProductService productService;
	
	@RequestMapping("/sale.do")
	public String sale(){
		return "sale";
	}
	@RequestMapping("/addSale.do")
	@ResponseBody
	public String addSale(Sale sale){
		saleService.insertSale(sale);
		if (sale.getSaleId()!=null) {
			return "1";
		}else{
			return "0";
		}
		
	}
	@RequestMapping("/saleinfo.do")
	public String saleinfo(PageBean<SaleShow> pageBean,Model model){
		/*System.out.println("进来了");
		System.out.println(pageBean.getCurrentPage());
		System.out.println("空被控");*/
		Integer currentPageInt = 1;
		if (pageBean.getCurrentPage()!=null&&pageBean.getCurrentPage()!=1) {
			currentPageInt = pageBean.getCurrentPage();
		}
		Integer currentCount = 5;
		//List<SaleShow> saleShowList = saleService.selectSale();
		/*for (SaleShow saleShow : saleShowList) {
			System.out.println(saleShow.getProduct().getProductName()+"==="+saleShow.getSale().getPrice());
		}*/
		pageBean = saleService.selectPageBean(currentPageInt,currentCount,pageBean.getOrderMethod());
		model.addAttribute("pageBean", pageBean);
		return "saleinfo";
	}
	
	
	
	
	
	
	
}
