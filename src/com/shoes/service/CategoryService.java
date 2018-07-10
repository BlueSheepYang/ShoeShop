package com.shoes.service;

import java.util.List;

import com.shoes.entity.Category;

public interface CategoryService {
	
	List<Category> getAllCategory();
	
	void deleteCategory(int id);
	
	void saveCategory(Category theCategory);
	
	Category getCategory(int id);

}
