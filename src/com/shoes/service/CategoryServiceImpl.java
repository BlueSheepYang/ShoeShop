package com.shoes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shoes.dao.CategoryDAO;
import com.shoes.entity.Category;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDAO categoryDAO;
	
	@Override
	@Transactional
	public List<Category> getAllCategory() {
		
		return categoryDAO.getAllCategory();
	}

	@Override
	@Transactional
	public void deleteCategory(int id) {

		categoryDAO.deleteCategory(id);
		
	}

	@Override
	public void saveCategory(Category theCategory) {
		
		categoryDAO.saveCategory(theCategory);

	}

	@Override
	public Category getCategory(int id) {
		
		return categoryDAO.getCategory(id);
	}

}
