package com.inm.stores.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.inm.stores.entities.SubCategory;

@Service
public interface SubCategoryService {
	
	SubCategory saveSubCategory(int catId, SubCategory subCategory);
	
	SubCategory updateSubCategory(int catId, int subCatId, SubCategory subCategory);
	
	void deleteSubCategory(SubCategory subCategory);
	
	Optional<SubCategory> getSubCategoryById(int id);
	
	List<SubCategory> getAllSubCategories();
	
	List<SubCategory> getAllSubCategoriesByCatId(int id);
	
	int deleteSubCategoryById(int subCatId);
	
	int isSubCategoryExist(int subCatId);

}
