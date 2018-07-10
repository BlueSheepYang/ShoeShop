package com.shoes.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.shoes.entity.Category;
import com.shoes.entity.Commodity;
import com.shoes.service.CategoryService;
import com.shoes.service.CommodityService;

@Controller
public class indexController {
	
	@Autowired
	private CommodityService commodityService;
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/")
	public String hello(Model theModel,HttpSession session) {
		
		
		List<Commodity> theCommodity = commodityService.getCommodity();
		
		List<Category> theCategory = categoryService.getAllCategory();
		
		theModel.addAttribute("commodities", theCommodity);
		
		theModel.addAttribute("categories",theCategory);
		
		System.out.println(theCommodity);
		
		return "hello_index";
	}
	
	@GetMapping("/Error")
	public String HandleError(Model model) {
		
		String info = "����Ȩ�޿��ܲ�������ע����ٽ�����������ע���ʱ��û��ͨ������ϵ����Ա";
		
		model.addAttribute("Info",info);
		
		return "error_404";
	}
	

}
