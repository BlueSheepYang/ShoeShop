package com.shoes.dao;

import java.util.List;

import com.shoes.entity.TmpCustomer;

public interface TmpCustomerDAO {

	public List<TmpCustomer> getCustomers();

	public void saveCustomer(TmpCustomer theCustomer);

	public TmpCustomer getCustomers(int theId);

	public void deleteCustomer(int theId);
	
}
