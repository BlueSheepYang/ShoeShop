package com.shoes.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shoes.entity.Customer;
import com.shoes.entity.Suggestion;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class SuggestionDAOImpl implements SuggestionDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Suggestion> getAllSuggestions(){
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Suggestion> theQuery = currentSession.createQuery("from Suggestion order by time",Suggestion.class);
		
		List<Suggestion> Suggestions = theQuery.getResultList();
		
		return Suggestions;
	}
	
	@Override
	@Transactional
	public List<Suggestion> getUnfinshedSuggestions(){
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Suggestion> theQuery = currentSession.createQuery("from Suggestion where handle=:flag",Suggestion.class);
		
		theQuery.setParameter("flag", 0);
		
		List<Suggestion> suggestions = theQuery.getResultList();
		
		return suggestions;
		
	}
	
	@Override
	@Transactional
	public List<Suggestion> getfinshedSuggestions(){
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Suggestion> theQuery = currentSession.createQuery("from Suggestion where handle=:flag",Suggestion.class);
		
		theQuery.setParameter("flag", 1);
		
		List<Suggestion> suggestions = theQuery.getResultList();
		
		return suggestions;
	}
	
	@Override
	@Transactional
	public Suggestion getSuggestion(int Id){
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read form datebase using the primary key
		Suggestion theSuggestion = currentSession.get(Suggestion.class, Id);
		
		return theSuggestion;
	}
	
	// 找某个人的全部建议信
	@Override
	@Transactional
	public List<Suggestion> getCustomerSuggestion(String name){
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Suggestion> theQuery = currentSession.createQuery("from Suggestion where name=:name",Suggestion.class);
		
		theQuery.setParameter("name", name);
		
		List<Suggestion> suggestions = theQuery.getResultList();
		
		return suggestions;
	}

	@Override
	public void saveSuggestion(Suggestion suggestion) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.save(suggestion);
		
	}

	@Override
	public void handleSuggestion(int Id) {
		
		int statue = 1;
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		String hql="update Suggestion suggestion set suggestion.handle = " +  statue + " where suggestion.id= " + Id;
		
		Query queryupdate = currentSession.createQuery(hql);
		
		queryupdate.executeUpdate();
		
	}

	@Override
	public void deleteSuggestion(int Id) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from Suggestion where id=:suggestionId");
		
		theQuery.setParameter("suggestionId", Id);
		
		theQuery.executeUpdate();
		
	}
	
	

}
