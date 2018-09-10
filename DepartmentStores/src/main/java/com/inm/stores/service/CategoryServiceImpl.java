package com.inm.stores.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.inm.stores.entities.Category;
import com.inm.stores.repos.CategoryRepo;

@Component
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepo catRepository;

	@Override
	public Category saveCategory(Category category) {
		return catRepository.save(category);
	}

	@Override
	public Category updateCategory(Category category) {
		return catRepository.save(category);
	}

	@Override
	public void deleteCategory(Category category) {
		catRepository.delete(category);
	}

	@Override
	public Optional<Category> getCategoryById(int id) {
		return catRepository.findById(id);
	}

	@Override
	public List<Category> getAllCategories() {
		return (List<Category>) catRepository.findAll();
	}

	public CategoryRepo getCatRepository() {
		return catRepository;
	}

	public void setCatRepository(CategoryRepo catRepository) {
		this.catRepository = catRepository;
	}

	@Override
	public List<Category> getAllCategoriesByDeptId(int id) {
		return catRepository.find(id);
	}

}
