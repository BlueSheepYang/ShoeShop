package com.shoes.service;

import java.util.List;

import com.shoes.entity.ShoppingCar;

public interface ShoppingCarService {
	
	public List<ShoppingCar> getShoppingCarList(String name);
	
	public void saveShoppingCarList(ShoppingCar theShoppingCar);

	public ShoppingCar getShoppingCar(int theId);

	public void deleteShoppingCar(int theShoppingCar);

}
