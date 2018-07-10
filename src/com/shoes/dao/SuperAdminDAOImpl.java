package com.shoes.dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.shoes.entity.SuperAdmin;

@Repository
public class SuperAdminDAOImpl implements SuperAdminDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveSuperAdmin(SuperAdmin superAdmin) {
		
		Session currentSession = sessionFactory.getCurrentSession();

		currentSession.saveOrUpdate(superAdmin);	
	}

	@Override
	public SuperAdmin getSuperAdmin(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		SuperAdmin theSuperAdmin = currentSession.get(SuperAdmin.class, theId);
		
		return theSuperAdmin;
	}

	@Override
	public void deleteShoppingCar(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();

		Query theQuery = currentSession.createQuery("delete from SuperAdmin where id=:Id");

		theQuery.setParameter("Id", theId);
		
		theQuery.executeUpdate();
		
	}
	

}
