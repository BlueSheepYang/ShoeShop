package com.shoes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shoes.dao.ShoppingCarDAO;
import com.shoes.entity.ShoppingCar;

@Service
public class ShoppingCarServiceImpl implements ShoppingCarService {

	@Autowired
	private ShoppingCarDAO shoppingCarDAO;
	
	@Override
	@Transactional
	public List<ShoppingCar> getShoppingCarList(String name) {
		
		return shoppingCarDAO.getShoppingCarList(name);
	}

	@Override
	@Transactional
	public void saveShoppingCarList(ShoppingCar theShoppingCar) {
		
		shoppingCarDAO.saveShoppingCarList(theShoppingCar);

	}

	@Override
	@Transactional
	public ShoppingCar getShoppingCar(int theId) {

		return shoppingCarDAO.getShoppingCar(theId);
	}

	@Override
	@Transactional
	public void deleteShoppingCar(int theShoppingCar) {
		
		shoppingCarDAO.deleteShoppingCar(theShoppingCar);

	}

}
