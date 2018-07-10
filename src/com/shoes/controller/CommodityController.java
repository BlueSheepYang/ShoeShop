package com.shoes.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shoes.entity.Commodity;
import com.shoes.entity.Customer;
import com.shoes.entity.OrderList;
import com.shoes.entity.ShoppingCar;
import com.shoes.service.CommodityService;
import com.shoes.service.CustomerService;
import com.shoes.service.OrderListService;
import com.shoes.service.ShoppingCarService;
import com.shoes.service.TmpCustomerService;

@Controller
@Transactional 
@RequestMapping("/commodity")
public class CommodityController{
	
	@Autowired
	private OrderListService orderListService;
	
	@Autowired
	private ShoppingCarService shoppingCarService;
	
	@Autowired
	private CommodityService commodityService;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	// need to inject customer service
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private TmpCustomerService tmpCustomerService;
		
	@RequestMapping(value="/detail")
	public String commodityDetail(@RequestParam("id") String commodityId,Model model) {
		
		Commodity commodity = commodityService.getCommodity(commodityId);
		
		model.addAttribute("theCommodity",commodity);
		
		return "commodity_detail";
		
	}
	
	// add product to shopping car
	@RequestMapping(value="/addShoppingCar")
	public String addToShoppingCar(@RequestParam("username") String username,@RequestParam("number") int number, @RequestParam("product-id") String productId,@RequestParam("productKind") String productType, Model model) {
		
		
		Commodity commodity = commodityService.getCommodity(productId);
		
		String sum = String.valueOf(commodity.getCommodityPrice() * number);
 		
		String productName = commodity.getCommodityName();
		
		String price = String.valueOf(commodity.getCommodityPrice());
			 		
 		String productNumber = String.valueOf(number);
 		
 		ShoppingCar shoppingCar = new ShoppingCar(username,productId,productName,price,productNumber,sum,productType);
 		
 		shoppingCarService.saveShoppingCarList(shoppingCar);
 		
 		System.out.println("success");
 		
 		return "redirect:/commodity/showShoppingCar";
	}
	
	@RequestMapping(value="/showShoppingCar")
	public String showShoppingCar(Model model,HttpSession session) {
		
		String username = String.valueOf(session.getAttribute("uname"));
		
		int i = 0;
		
		String picLink;
		
		List<String> links = new ArrayList<String>();
				
		List<ShoppingCar> shoppingcarList =  shoppingCarService.getShoppingCarList(username);
		
		while(i<shoppingcarList.size()) {
			
			picLink = commodityService.getCommodity(shoppingcarList.get(i).getProductId()).getCommodityPictureLink();
		
			links.add(picLink);
					
			System.out.println(links);
			
			i++;
		}
		
		Double totalSum = 0.0;
		
		i = 0;
				
		while(i<shoppingcarList.size()) {
			
			totalSum = totalSum + Double.parseDouble(shoppingcarList.get(i).getSum());
			
			System.out.println(shoppingcarList.get(i).getSum());
			
			i=i+1;
		}
		
		System.out.println(totalSum);
		
		model.addAttribute("totalSum", totalSum);
		
		model.addAttribute("picLink",links);
		
		model.addAttribute("shoppingcarLists", shoppingcarList);
		
		System.out.println(shoppingcarList);
		
		return "shopping-car";
		
	}
	
	@RequestMapping(value="/confirmList")
	public String confirmList(@RequestParam("id") int listId) throws ParseException {
		
		int number = 0;
		
		ShoppingCar list = shoppingCarService.getShoppingCar(listId);
		
		shoppingCarService.deleteShoppingCar(listId);
		
		Customer customer = customerService.getCustomer(list.getUserNickName());
		
		Commodity commodity = commodityService.getCommodity(list.getProductId());
		
		int nowNumber = commodity.getCommodityNumber() - Integer.parseInt(list.getProductNumber());
		
		commodity.setCommodityNumber(nowNumber);
		
		commodityService.saveCommodity(commodity);
		
		System.out.println(customer);
		
		Date day=new Date();    

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		
		System.out.println(df.parse(df.format(day)));
		
		OrderList theOrderList = new OrderList(df.parse(df.format(day)),list.getProductId(),list.getProductName(),list.getSum(),customer.getUserId(),customer.getUserTrueName(),customer.getUserAddress(),customer.getUserPhone(),number,list.getProductKind());
		
		orderListService.saveOrderList(theOrderList);
				
		return "redirect:/commodity/showShoppingCar";
	}

	@RequestMapping(value="/confirmAllList")
	public String confirmAllList(HttpSession session) throws ParseException  {
		
		int number = 0;
		
		List<ShoppingCar> shoppingCars = shoppingCarService.getShoppingCarList(session.getAttribute("uname").toString());
		
		for(int i=0;i<shoppingCars.size();i++) {
			
			shoppingCarService.deleteShoppingCar(shoppingCars.get(i).getId());
			
			Customer customer = customerService.getCustomer(shoppingCars.get(i).getUserNickName());
			
			Commodity commodity = commodityService.getCommodity(shoppingCars.get(i).getProductId());
			
			int nowNumber = commodity.getCommodityNumber() - Integer.parseInt(shoppingCars.get(i).getProductNumber());
			
			commodity.setCommodityNumber(nowNumber);
			
			commodityService.saveCommodity(commodity);
						
			Date day=new Date();    

			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
			
			System.out.println(df.parse(df.format(day)));
			
			OrderList theOrderList = new OrderList(df.parse(df.format(day)),shoppingCars.get(i).getProductId(),shoppingCars.get(i).getProductName(),shoppingCars.get(i).getSum(),customer.getUserId(),customer.getUserTrueName(),customer.getUserAddress(),customer.getUserPhone(),number,shoppingCars.get(i).getProductKind());
			
			orderListService.saveOrderList(theOrderList);
			
		}
		
		return "redirect:/commodity/showShoppingCar";
		
	}

}
