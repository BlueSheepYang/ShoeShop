package com.shoes.dao;

import java.util.List;

import com.shoes.entity.OrderList;

public interface OrderListDAO {
	
	public List<OrderList> getOrderLists();
	
	public OrderList getOrderList(String id);
	
	public void saveOrderList(OrderList theOrderList);
	
	public void deleteOrderList(int theId);

	void updateOrderList(int orderId);

	public List<OrderList> getFinishedLists();

	public List<OrderList> getAllLists();

	public List<OrderList> getCustomerFinishedList(String name);

	List<OrderList> getCustomerUnfinishedList(String name);

	List<OrderList> getCustomerAllList(String name);	

}
