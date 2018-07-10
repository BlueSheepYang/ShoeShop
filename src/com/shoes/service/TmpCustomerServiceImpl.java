package com.shoes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shoes.dao.TmpCustomerDAO;
import com.shoes.entity.TmpCustomer;


@Service
public class TmpCustomerServiceImpl implements TmpCustomerService {

	// need to inject customer dao
		@Autowired
		private TmpCustomerDAO tmpCustomerDAO;
		
		@Override
		@Transactional
		public List<TmpCustomer> getCustomers() {
			
			return tmpCustomerDAO.getCustomers();
		}

		@Override
		@Transactional
		public void saveCustomer(TmpCustomer theCustomer) {

			
			tmpCustomerDAO.saveCustomer(theCustomer);
		}

		@Override
		@Transactional
		public TmpCustomer getCustomer(int theId) {
			
			return tmpCustomerDAO.getCustomers(theId);
		}

		@Override
		@Transactional
		public void deleteCustomer(int theId) {

			tmpCustomerDAO.deleteCustomer(theId);
			
		}


}
