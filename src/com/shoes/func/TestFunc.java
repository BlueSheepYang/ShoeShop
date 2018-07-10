package com.shoes.func;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.shoes.service.OrderListService;

public class TestFunc {

	@Autowired
	public OrderListService orderListService;
	
	public static void main(String[] args) {
		
		Statistical sta = new Statistical();
		
		//List info = sta.statisticalCustomer(orderListService.);

	}

}
