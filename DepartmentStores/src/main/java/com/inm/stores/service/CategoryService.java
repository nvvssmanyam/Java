package com.inm.stores.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.inm.stores.entities.Category;

@Service
public interface CategoryService {
	
	Category saveCategory(int deptId, Category category);
	
	Category updateCategory(int deptId, int catId, Category category);
	
	void deleteCategory(Category category);
	
	int deleteCategoryById(int id);
	
	Optional<Category> getCategoryById(int id);
	
	List<Category> getAllCategories();
	
	List<Category> getAllCategoriesByDeptId(int id);
	
	int isCategoryExist(int catId);

}
