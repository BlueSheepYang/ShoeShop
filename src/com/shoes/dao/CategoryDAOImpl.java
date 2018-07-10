package com.shoes.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shoes.entity.Category;
import com.shoes.entity.Customer;

@Repository
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Category> getAllCategory() {
		
		Session currentSession = sessionFactory.getCurrentSession();	
		
		Query<Category> theQuery = 
				currentSession.createQuery("from Category order by CategoryId", Category.class);
		
		// execute the query and get result list
		List<Category> category = theQuery.getResultList();
				
		// return the result
		return category;
	}

	@Override
	public void deleteCategory(int Id) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = currentSession.createQuery("delete from Category where CategoryId=:id");
		
		theQuery.setParameter("id", Id);
		
		theQuery.executeUpdate();

	}

	@Override
	public void saveCategory(Category theCategory) {
		
		Session currentCategory = sessionFactory.getCurrentSession();
		
		currentCategory.saveOrUpdate(theCategory);

	}

	@Override
	public Category getCategory(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Category theCategory = currentSession.get(Category.class, theId);
		
		return theCategory;
	}

}
