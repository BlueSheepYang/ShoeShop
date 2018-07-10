package com.shoes.dao;

import java.util.List;

import com.shoes.entity.Category;

public interface CategoryDAO {
	
	List<Category> getAllCategory();
	void deleteCategory(int id);
	void saveCategory(Category theCategory);
	Category getCategory(int id);
}
