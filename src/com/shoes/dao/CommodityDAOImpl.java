package com.shoes.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shoes.entity.Commodity;
import com.shoes.entity.Customer;

@Repository
public class CommodityDAOImpl implements CommodityDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
		
	@Override
	public List<Commodity> getCommodity() {
		
		// get a current hibernate sesssion
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query 
		Query<Commodity> theQuery = 
				currentSession.createQuery("from Commodity order by CommodityId", Commodity.class);
		
		// execute the query and get result list
		List<Commodity> commodity = theQuery.getResultList();
				
		// return the result
		return commodity;
		
	}

	@Override
	public Commodity getCommodity(String id) {
		// TODO Auto-generated method stub
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Commodity theCommodity = currentSession.get(Commodity.class, id);
		
		return theCommodity;
	}
	
	@Override
	public void saveCommodity(Commodity commdity) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.save(commdity);
		
	}

	@Override
	public List<Commodity> getCommodityByPeople(String sex, String people) {
		
		// get a current hibernate sesssion
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query 
		Query<Commodity> theQuery = 
				currentSession.createQuery("from Commodity where commoditysex=:Sex and commodityfitpeople=:People", Commodity.class);
		
		theQuery.setParameter("Sex", sex);
		
		theQuery.setParameter("People", people);
		
		// execute the query and get result list
		List<Commodity> commodity = theQuery.getResultList();
				
		// return the result
		return commodity;
	}

	@Override
	public List<Commodity> getCommodityBySeason(String season) {
		
		// get a current hibernate sesssion
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query 
		Query<Commodity> theQuery = 
				currentSession.createQuery("from Commodity where CommoditySeason=:Season", Commodity.class);
		
		theQuery.setParameter("Season", season);
		
		// execute the query and get result list
		List<Commodity> commodity = theQuery.getResultList();
				
		// return the result
		return commodity;
	}

	@Override
	public List<Commodity> getCommodityByKinds(String sex, String kind) {
		
		// get a current hibernate sesssion
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query 
		Query<Commodity> theQuery = 
				currentSession.createQuery("from Commodity where CommoditySex=:Sex and CommodityType=:Kind", Commodity.class);
		
		theQuery.setParameter("Sex", sex);
		
		theQuery.setParameter("Kind", kind);
		
		// execute the query and get result list
		List<Commodity> commodity = theQuery.getResultList();
				
		// return the result
		return commodity;
	}

}
