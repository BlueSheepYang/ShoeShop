package com.shoes.service;

import java.util.List;

import com.shoes.entity.TmpCustomer;

public interface TmpCustomerService {

	public List<TmpCustomer> getCustomers();

	public void saveCustomer(TmpCustomer theCustomer);

	public TmpCustomer getCustomer(int theId);

	public void deleteCustomer(int theId);
	
}
