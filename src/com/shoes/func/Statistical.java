package com.shoes.func;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

import com.shoes.entity.OrderList;
public class Statistical{
	
	
	@SuppressWarnings("deprecation")
	public static Double GetSameDate_Month(int month, List<OrderList> stuList){
		Double sum = 0.0;
		List<OrderList> same_Month = new ArrayList<OrderList>();
		for(int i=0;i<stuList.size();i++)
		{
			System.out.print(stuList.get(i).getOrderTime().getMonth());
			if(stuList.get(i).getOrderTime().getMonth() == month - 1) //数据库月份从0开始计数，所以-1
			{
				same_Month.add(stuList.get(i));
				System.out.print(stuList.get(i).getOrderTime());
			}
		}
		for(int i=0;i<same_Month.size();i++) {
			sum = sum + Double.parseDouble(same_Month.get(i).getOrderTotalMoney());
		}
		return sum;
	}
	
	@SuppressWarnings("deprecation")
	public static Double GetSameDate_Day(int month,int day, List<OrderList> stuList){
		Double sum = 0.0;
		List<OrderList> same_Month = new ArrayList<OrderList>();
		for(int i=0;i<stuList.size();i++)
		{
			String onth = stuList.get(i).getOrderTime().toString();		//没有获取天数这个函数，只有截取字符串变相应数字
			int getDay = Integer.parseInt(onth.substring(8,10));
			if(stuList.get(i).getOrderTime().getMonth() == month - 1 && getDay == day) //数据库月份从0开始计数，所以-1
			{
				same_Month.add(stuList.get(i));
			}
		}
		for(int i=0;i<same_Month.size();i++) {
			sum = sum + Double.parseDouble(same_Month.get(i).getOrderTotalMoney());
		}
		return sum;
	}
	
	public int getMomentDay() {
		
		Calendar now = Calendar.getInstance();  
        System.out.println("年: " + now.get(Calendar.YEAR));  
        System.out.println("月: " + (now.get(Calendar.MONTH) + 1) + "");  
        System.out.println("日: " + now.get(Calendar.DAY_OF_MONTH));  
        
		return now.get(Calendar.DAY_OF_MONTH);
	}
	
	public int getMonth() {
		Calendar now = Calendar.getInstance();  
        System.out.println("年: " + now.get(Calendar.YEAR));  
        System.out.println("月: " + (now.get(Calendar.MONTH) + 1) + "");  
        System.out.println("日: " + now.get(Calendar.DAY_OF_MONTH));  
        
		return now.get(Calendar.MONTH) + 1;
	}
	public List statisticalAllKinds(List<OrderList> orderList){
		
		String name;
		
		List<String> types = new ArrayList();
		
		List<Double> typeSum = new ArrayList();
		
		List typesAndTypeSum = new ArrayList();
		
		int flag = 0;
		
		types.add(orderList.get(0).getOrderCommodityType());
		System.out.println("\n");
		for(int i=1;i<orderList.size();i++) {
			for(int k=0;k<types.size();k++) {
				if(types.get(k).equals(orderList.get(i).getOrderCommodityType())) {
					flag = 1;
				}
			}
			if(flag==0) {
				types.add(orderList.get(i).getOrderCommodityType());
			}
			flag = 0;
		}
		
		for(int i=0;i<types.size();i++) {
			Double sum = 0.0;
			for(int j=0;j<orderList.size();j++) {
				if(orderList.get(j).getOrderCommodityType().equals(types.get(i))) {
					sum = sum + Double.parseDouble( orderList.get(j).getOrderTotalMoney());
				}
			}
			typeSum.add(sum);
			sum = 0.0;
		}
		typesAndTypeSum.add(types);
		typesAndTypeSum.add(typeSum);
		return typesAndTypeSum;
	}
	
	public List statisticalAllCustomers(List<OrderList> orderList){
		
		String name;
					
		List<String> customers = new ArrayList();
		
		List<Double> customerSum = new ArrayList();
		
		List customerAndSum = new ArrayList();
		
		int flag = 0;
		
		customers.add(orderList.get(0).getOrderCustomerName());
		System.out.println("\n");
		for(int i=1;i<orderList.size();i++) {
			for(int k=0;k<customers.size();k++) {
				if(customers.get(k).equals(orderList.get(i).getOrderCustomerName())) {
					flag = 1;
				}
			}
			if(flag==0) {
				customers.add(orderList.get(i).getOrderCustomerName());
			}
			flag = 0;
		}
		
		for(int i=0;i<customers.size();i++) {
			Double sum = 0.0;
			for(int j=0;j<orderList.size();j++) {
				if(orderList.get(j).getOrderCustomerName().equals(customers.get(i))) {
					sum = sum + Double.parseDouble( orderList.get(j).getOrderTotalMoney());
				}
			}
			customerSum.add(sum);
			sum = 0.0;
		}
		customerAndSum.add(customers);
		customerAndSum.add(customerSum);
		return customerAndSum;
	}

}
