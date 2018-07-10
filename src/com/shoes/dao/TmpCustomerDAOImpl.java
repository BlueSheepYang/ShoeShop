package com.shoes.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shoes.entity.Customer;
import com.shoes.entity.TmpCustomer;

@Repository
public class TmpCustomerDAOImpl implements TmpCustomerDAO{
	
	// need to inject the session factory
		@Autowired
		private SessionFactory sessionFactory;
				
		@Override
		public List<TmpCustomer> getCustomers() {
			
			// get the current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();
					
			// create a query .. sort by truename
			Query<TmpCustomer> theQuery = 
					currentSession.createQuery("from TmpCustomer order by usertruename", TmpCustomer.class);
			
			// execute query and get result list
			List<TmpCustomer> customers = theQuery.getResultList();
					
			// return the results		
			return customers;
		}

		@Override
		public void saveCustomer(TmpCustomer theCustomer) {

			// get current hibernate session
			Session currentCustomer = sessionFactory.getCurrentSession();
			
			// save/update the customer ... finally LOL
			currentCustomer.saveOrUpdate(theCustomer);
		}

		@Override
		public TmpCustomer getCustomers(int theId) {
			
			// get the current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();
			
			// now retrieve/read form datebase using the primary key
			TmpCustomer theCustomer = currentSession.get(TmpCustomer.class, theId);
			
			return theCustomer;
		}

		@Override
		public void deleteCustomer(int theId) {
			
			// get hibernate session
			Session currentSession = sessionFactory.getCurrentSession();
			
			// delete object with primary key
			Query theQuery = currentSession.createQuery("delete from TmpCustomer where id=:customerId");
			
			theQuery.setParameter("customerId", theId);
			
			theQuery.executeUpdate();
			
		}

}
