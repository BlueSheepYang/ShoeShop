package com.shoes.service;

import java.util.List;

import com.shoes.entity.OrderList;

public interface OrderListService {
	
	public List<OrderList> getOrderList();
	
	public OrderList getOrderList(String id);
	
	public void saveOrderList(OrderList theOrderList);
	
	public void deleteOrderList(int theId);

	void updateOrderList(int orderId);
	
	List<OrderList> getFinishedLists();

	List<OrderList> getAllLists();

	List<OrderList> getCustomerFinishedList(String name);

	List<OrderList> getCustomerAllList(String name);

	List<OrderList> getCustomerUnfinishedList(String name);	

}
