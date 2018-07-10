package com.shoes.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shoes.entity.OrderList;
import com.shoes.entity.Reply;

@Repository
public class ReplyDAOImpl implements ReplyDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveReply(Reply reply) {

		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.save(reply);
	}

	@Override
	public Reply getReply(int suggestionId) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read form datebase using the primary key
		Reply theReply = currentSession.get(Reply.class, suggestionId);
		
		return theReply;
	}
	
	@Override
	public List<Reply> getCustomerReply(String name){
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Reply> theQuery = currentSession.createQuery("from Reply where ToUser=:Name", Reply.class);
				
		theQuery.setParameter("Name", name);
		
		List<Reply> reply = theQuery.getResultList();
		
		return reply;
	}

}
