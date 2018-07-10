package com.shoes.dao;

import java.util.List;

import com.shoes.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomers(int theId);
	
	public Customer getCustomer(String name);

	public void deleteCustomer(int theId);
	
}
