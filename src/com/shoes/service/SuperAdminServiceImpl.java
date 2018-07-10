package com.shoes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shoes.dao.SuperAdminDAO;
import com.shoes.entity.OrderList;
import com.shoes.entity.SuperAdmin;

@Service
public class SuperAdminServiceImpl implements SuperAdminService {

	@Autowired
	private SuperAdminDAO superAdminDAO;
	
	@Override
	@Transactional
	public void saveSuperAdmin(SuperAdmin superAdmin) {
		
		superAdminDAO.saveSuperAdmin(superAdmin);

	}

	@Override
	@Transactional
	public SuperAdmin getSuperAdmin(int theId) {
		
		return superAdminDAO.getSuperAdmin(theId);
	}

	@Override
	@Transactional
	public void deleteShoppingCar(int theSuperAdmin) {
		
		superAdminDAO.deleteShoppingCar(theSuperAdmin);

	}

}
