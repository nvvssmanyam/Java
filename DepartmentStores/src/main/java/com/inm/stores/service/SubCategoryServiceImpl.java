package com.inm.stores.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.inm.stores.entities.Category;
import com.inm.stores.entities.SubCategory;
import com.inm.stores.repos.SubCategoryRepo;

@Component
public class SubCategoryServiceImpl implements SubCategoryService {

	@Autowired
	SubCategoryRepo subCatRepository;
	
	@Autowired
	CategoryService catService;
	
	public SubCategoryRepo getSubCatRepository() {
		return subCatRepository;
	}

	public void setSubCatRepository(SubCategoryRepo subCatRepository) {
		this.subCatRepository = subCatRepository;
	}

	@Override
	public SubCategory saveSubCategory(int catId, SubCategory subCategory) {
		Optional<Category> category = catService.getCategoryById(catId);
		if(category.isPresent()) {
			subCategory.setCategory(category.get());
			return subCatRepository.save(subCategory);
		}
		return null;
	}

	@Override
	public SubCategory updateSubCategory(int catId, int subCatId, SubCategory subCategoryDetails) {
		Optional<Category> category = catService.getCategoryById(catId);
		if (category.isPresent()) {
			SubCategory subCategory = new SubCategory();
			subCategory.setSubCatId(subCatId);
			subCategory.setCategory(category.get());
			subCategory.setSubCatName(subCategoryDetails.getSubCatName());
			return subCatRepository.save(subCategory);
		}
		return null;
	}

	@Override
	public void deleteSubCategory(SubCategory subCategory) {
		subCatRepository.delete(subCategory);
	}
	
	public int deleteSubCategoryById(int id) {
		if(isSubCategoryExist(id) > 0) {
			subCatRepository.deleteById(id);
			return 1;
		}
		return 0;
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
		return (List<SubCategory>) subCatRepository.find(id);
	}

	@Override
	public int isSubCategoryExist(int subCatId) {
		return subCatRepository.isRecordExist(subCatId);
	}
	
}
