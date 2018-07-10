package com.shoes.service;

import java.util.List;

import com.shoes.entity.OrderList;
import com.shoes.entity.SuperAdmin;

public interface SuperAdminService {
	
	
	public void saveSuperAdmin(SuperAdmin superAdmin);

	public SuperAdmin getSuperAdmin(int theId);

	public void deleteShoppingCar(int theSuperAdmin);
	
}
