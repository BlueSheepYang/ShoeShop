package com.shoes.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shoes.entity.ShoppingCar;

@Repository
public class ShoppingCarDAOImpl implements ShoppingCarDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<ShoppingCar> getShoppingCarList(String name) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query .. sort by truename
		Query<ShoppingCar> theQuery = 
				currentSession.createQuery("from ShoppingCar where usernickname=:username ", ShoppingCar.class);
		
        theQuery.setParameter("username", name);
				
		// execute query and get result list
		List<ShoppingCar> ShoppingCarList = theQuery.getResultList();
				
		// return the results		
		return ShoppingCarList;
	}

	@Override
	public void saveShoppingCarList(ShoppingCar theShoppingCar) {
		
		Session currentShoppingCar = sessionFactory.getCurrentSession();
		
		// save/update the customer ... finally LOL
		currentShoppingCar.saveOrUpdate(theShoppingCar);
		

	}

	@Override
	public ShoppingCar getShoppingCar(int theId) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read form datebase using the primary key
		ShoppingCar theShoppingCar = currentSession.get(ShoppingCar.class, theId);
		
		return theShoppingCar;
	}

	@Override
	public void deleteShoppingCar(int theId) {
		
		// get hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from ShoppingCar where id=:Id");
		
		theQuery.setParameter("Id", theId);
		
		theQuery.executeUpdate();

	}

}
