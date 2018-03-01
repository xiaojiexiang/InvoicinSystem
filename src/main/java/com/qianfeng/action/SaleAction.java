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

	/**
	 * 主要对显示的数据进行分页,要得到当前页码,将页码和每页显示条数传到service层进行操作
	 * @param pageBean
	 * @param model
	 * @return
	 */
	@RequestMapping("/saleinfo.do")
	public String saleinfo(PageBean<SaleShow> pageBean,Model model){

		Integer currentPageInt = 1;
		//判断当前页页码
		if (pageBean.getCurrentPage()!=null&&pageBean.getCurrentPage()!=1) {
			currentPageInt = pageBean.getCurrentPage();
		}
		//每页要显示的数据条数(通用pageSize)
		Integer currentCount = 5;

		pageBean = saleService.selectPageBean(currentPageInt,currentCount,pageBean.getOrderMethod());
		model.addAttribute("pageBean", pageBean);
		return "saleinfo";
	}
	
	
	
	
	
	
	
}
