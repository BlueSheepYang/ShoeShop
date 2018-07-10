package com.shoes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shoes.dao.OrderListDAO;
import com.shoes.entity.OrderList;

@Service
public class OrderListServiceImpl implements OrderListService {

	@Autowired
	private OrderListDAO orderListDAO;
	
	@Override
	@Transactional
	public List<OrderList> getOrderList() {
		
		return orderListDAO.getOrderLists();
	}

	@Override
	@Transactional
	public OrderList getOrderList(String id) {
		
		return orderListDAO.getOrderList(id);
	}

	@Override
	@Transactional
	public void saveOrderList(OrderList theOrderList) {
		
		orderListDAO.saveOrderList(theOrderList);

	}

	@Override
	@Transactional
	public void deleteOrderList(int theId) {
		
		orderListDAO.deleteOrderList(theId);

	}

	@Override
	public void updateOrderList(int orderId) {
		
		orderListDAO.updateOrderList(orderId);
		
	}

	@Override
	public List<OrderList> getFinishedLists() {
		
		return orderListDAO.getFinishedLists();
		
	}

	@Override
	public List<OrderList> getAllLists() {
		
		return orderListDAO.getAllLists();
	}
	
	@Override 
	public List<OrderList> getCustomerFinishedList(String name){
				
		return orderListDAO.getCustomerFinishedList(name);
	}
	
	@Override 
	public List<OrderList> getCustomerUnfinishedList(String name){
				
		return orderListDAO.getCustomerUnfinishedList(name);
	}
	
	@Override 
	public List<OrderList> getCustomerAllList(String name){
				
		return orderListDAO.getCustomerAllList(name);
	}

}
