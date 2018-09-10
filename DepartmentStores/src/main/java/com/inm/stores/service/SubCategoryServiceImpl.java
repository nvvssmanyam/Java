package com.inm.stores.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.inm.stores.entities.SubCategory;
import com.inm.stores.repos.SubCategoryRepo;

@Component
public class SubCategoryServiceImpl implements SubCategoryService {

	@Autowired
	SubCategoryRepo subCatRepository;
	
	public SubCategoryRepo getSubCatRepository() {
		return subCatRepository;
	}

	public void setSubCatRepository(SubCategoryRepo subCatRepository) {
		this.subCatRepository = subCatRepository;
	}

	@Override
	public SubCategory saveSubCategory(SubCategory subCategory) {
		return subCatRepository.save(subCategory);
	}

	@Override
	public SubCategory updateSubCategory(SubCategory subCategory) {
		return subCatRepository.save(subCategory);
	}

	@Override
	public void deleteSubCategory(SubCategory subCategory) {
		subCatRepository.delete(subCategory);
	}

	@Override
	public Optional<SubCategory> getSubCategoryById(int id) {
		return subCatRepository.findById(id);
	}

	@Override
	public List<SubCategory> getAllSubCategories() {
		return (List<SubCategory>) subCatRepository.findAll();
	}

	@Override
	public List<SubCategory> getAllSubCategoriesByCatId(int id) {
		return subCatRepository.find(id);
	}
	
}
