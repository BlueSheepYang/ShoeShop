package com.shoes.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shoes.entity.OrderList;

@Repository
public class OrderListDAOImpl implements OrderListDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<OrderList> getOrderLists() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<OrderList> theQuery = currentSession.createQuery("from OrderList where orderhandleornot=:id ", OrderList.class);
		
		theQuery.setParameter("id", 0);
		
		List<OrderList> orderLists = theQuery.getResultList();
		
		return orderLists;
		
	}
	
	@Override
	public List<OrderList> getFinishedLists(){
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<OrderList> theQuery = currentSession.createQuery("from OrderList where orderhandleornot=:id ", OrderList.class);
		
		theQuery.setParameter("id", 1);
		
		List<OrderList> orderLists = theQuery.getResultList();
		
		return orderLists;
		
	}
	
	@Override 
	public List<OrderList> getCustomerFinishedList(String name){
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<OrderList> theQuery = currentSession.createQuery("from OrderList where ordercustomername=:Name and orderhandleornot=:id", OrderList.class);
		
		theQuery.setParameter("id", 1);
		
		theQuery.setParameter("Name", name);
		
		List<OrderList> orderLists = theQuery.getResultList();
		
		return orderLists;
	}
	
	@Override 
	public List<OrderList> getCustomerUnfinishedList(String name){
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<OrderList> theQuery = currentSession.createQuery("from OrderList where ordercustomername=:Name and orderhandleornot=:id", OrderList.class);
		
		theQuery.setParameter("id", 0);
		
		theQuery.setParameter("Name", name);
		
		List<OrderList> orderLists = theQuery.getResultList();
		
		return orderLists;
	}
	
	@Override
	public List<OrderList> getCustomerAllList(String name){
			
			Session currentSession = sessionFactory.getCurrentSession();
			
			Query<OrderList> theQuery = currentSession.createQuery("from OrderList where ordercustomername=:Name", OrderList.class);
			
			theQuery.setParameter("Name", name);
			
			List<OrderList> orderLists = theQuery.getResultList();
			
			return orderLists;
	}
	
	@Override
	public List<OrderList> getAllLists(){
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<OrderList> theQuery = currentSession.createQuery("from OrderList ", OrderList.class);
				
		List<OrderList> orderLists = theQuery.getResultList();
		
		return orderLists;
		
	}

	@Override
	public OrderList getOrderList(String id) {
		
		Session currentOrderList = sessionFactory.getCurrentSession();

		OrderList theOrderList = currentOrderList.get(OrderList.class, id);

		return theOrderList;
		
	}

	@Override
	public void saveOrderList(OrderList theOrderList) {

		Session currentOrderList = sessionFactory.getCurrentSession();
		
		currentOrderList.save(theOrderList);
		
	}

	@Override
	public void deleteOrderList(int theId) {

		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = currentSession.createQuery("delete from OrderList where id=:orderId");
		
		theQuery.setParameter("orderId", theId);
		
		theQuery.executeUpdate();

		
	}
	
	@Override
	public void updateOrderList(int orderId) {
		
		int statue = 1;
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		String hql="update OrderList orderlist set orderlist.orderHandleOrNot = " +  statue + " where orderlist.orderId= " + orderId;
		
		Query queryupdate = currentSession.createQuery(hql);
		
		queryupdate.executeUpdate();
				
	}
	

}
