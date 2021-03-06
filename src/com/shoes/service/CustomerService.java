package com.shoes.service;

import java.util.List;

import com.shoes.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);
	
	public Customer getCustomer(String name);
		
	

}
