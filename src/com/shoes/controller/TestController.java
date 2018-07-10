package com.shoes.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.shoes.entity.OrderList;
import com.shoes.func.Statistical;
import com.shoes.service.OrderListService;



@Controller
@Transactional 
@RequestMapping(value="/test")
public class TestController {

	
	@Autowired
	private OrderListService orderListService;
	
	
	@RequestMapping(value="/showList")
	public String showList(Model model) {
		
		Statistical sta = new Statistical();
		
		List info = sta.statisticalAllKinds(orderListService.getAllLists());
		
		System.out.println(info);
		
		return "admin/showListWaittingToHandle";
	}
}
