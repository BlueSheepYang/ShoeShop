package com.shoes.dao;

import java.util.List;

import com.shoes.entity.OrderList;
import com.shoes.entity.SuperAdmin;

public interface SuperAdminDAO {
	
	public void saveSuperAdmin(SuperAdmin superAdmin);

	public SuperAdmin getSuperAdmin(int theId);

	public void deleteShoppingCar(int theId);

}
