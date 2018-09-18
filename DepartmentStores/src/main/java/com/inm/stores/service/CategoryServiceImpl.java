package com.inm.stores.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.inm.stores.entities.Category;
import com.inm.stores.entities.Department;
import com.inm.stores.repos.CategoryRepo;

@Component
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepo catRepository;
	
	@Autowired
	private DepartmentService deptService;
	
	@Override
	public Category saveCategory(int deptId, Category category) {
		Optional<Department> department = deptService.getDepartmentByDeptId(deptId);
		if(department.isPresent()) {
			category.setDepartment(department.get());
			return catRepository.save(category);
		}
		return null;
	}

	@Override
	public Category updateCategory(int deptId, int catId, Category categoryDeatils) {
		Optional<Department> department = deptService.getDepartmentByDeptId(deptId);
		Optional<Category> category = getCategoryById(catId);
		Category cat = category.get();
		cat.setCatId(catId);
		cat.setCatName(categoryDeatils.getCatName());
		cat.setDepartment(department.get());
		return catRepository.save(cat);
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
	
	public int deleteCategoryById(int id) {
		if(isCategoryExist(id) > 0) {
			catRepository.deleteById(id);
			return 1;
		}
		return 0;
	}
	
	@Override
	public int isCategoryExist(int catId) {
		return catRepository.isRecordExist(catId);
	}

}
