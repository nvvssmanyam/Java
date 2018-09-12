package com.inm.stores.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inm.stores.entities.Category;
import com.inm.stores.entities.Department;
import com.inm.stores.entities.Location;
import com.inm.stores.entities.SubCategory;
import com.inm.stores.service.CategoryService;
import com.inm.stores.service.DepartmentService;
import com.inm.stores.service.LocationService;
import com.inm.stores.service.SubCategoryService;

@RestController
@RequestMapping("/api/v1")
@Produces("application/json")
@CrossOrigin
public class SubCategoryAPIController {

	@Autowired
	LocationService locService;
	
	@Autowired
	DepartmentService deptService;
	
	@Autowired
	CategoryService catService;
	
	@Autowired
	SubCategoryService subCatService;
	
	@GetMapping("/location/{id}/department/{did}/category/{cid}/subcategory")
	public List<SubCategory> getSubCategories(@PathVariable(value="id") int locId, @PathVariable(value="did") int deptId, 
			@PathVariable(value="cid") int catId) {
		Optional<Location> loc = locService.getLocationById(locId);
		if(loc.get() != null) {
			Set<Department> depts = loc.get().getDepartments();
			for (Department department : depts) {
				if(deptId == department.getDeptId()) {
					List<Category> catagories = catService.getAllCategoriesByDeptId(deptId);
					for (Category category : catagories) {
						if(catId == category.getCatId()) {
							return subCatService.getAllSubCategoriesByCatId(catId);
						}
					}
				} 
			}
		}
		return null;
	}
	
	@GetMapping("/location/{id}/department/{did}/category/{cid}/subcategory/{sid}")
	public Optional<SubCategory> getSubCategoryByCatId(@PathVariable(value="id") int locId, @PathVariable(value="did") int deptId, 
			@PathVariable(value="cid") int catId, @PathVariable(value="sid") int subCatId) {
		Optional<Location> loc = locService.getLocationById(locId);
		if(loc.get() != null) {
			Set<Department> depts = loc.get().getDepartments();
			for (Department department : depts) {
				if(deptId == department.getDeptId()) {
					List<Category> catagories = catService.getAllCategoriesByDeptId(deptId);
					for (Category category : catagories) {
						if(catId == category.getCatId()) {
							List<SubCategory> subCategories = subCatService.getAllSubCategoriesByCatId(catId);
							for (SubCategory subCategory : subCategories) {
								if(subCatId == subCategory.getSubCatId()) {
									return subCatService.getSubCategoryById(subCatId);
								}
							}
						}
					}
				} 
			}
		}
		return null;
	}
	
	@PostMapping("/location/{id}/department/{did}/category/{cid}/subcategory")
	public SubCategory createSubCategory(@PathVariable(value="id") int locId, @PathVariable(value="did") int deptId,
			@PathVariable(value="cid") int catId, @Valid @RequestBody SubCategory subCategory) {
		Optional<Location> loc = locService.getLocationById(locId);
		if(loc.get() != null) {
			Set<Department> depts = loc.get().getDepartments();
			for (Department department : depts) {
				if(deptId == department.getDeptId()) {
					List<Category> catagories = catService.getAllCategoriesByDeptId(deptId);
					for (Category category : catagories) {
						if(catId == category.getCatId()) {
							subCategory.setCategory(category);
							return subCatService.saveSubCategory(subCategory);
						}
					}
				} 
			}
		}
		return null;
	}
	
	@PutMapping("/location/{id}/department/{did}/category/{cid}/subcategory/{sid}")
	public SubCategory updateSubCategory(@PathVariable(value="id") int locId, @PathVariable(value="did") int deptId,
			@PathVariable(value="cid") int catId, @PathVariable(value="sid") int subCatId,
			@Valid @RequestBody SubCategory subCategoryDeatils) {
		Optional<Location> loc = locService.getLocationById(locId);
		if(loc.get() != null) {
			Set<Department> depts = loc.get().getDepartments();
			for (Department department : depts) {
				if(deptId == department.getDeptId()) {
					List<Category> categories = catService.getAllCategoriesByDeptId(deptId);
					for (Category catgry : categories) {
						if(catId == catgry.getCatId()) {
							List<SubCategory> subCategories = subCatService.getAllSubCategoriesByCatId(catId);
							for (SubCategory subCategory : subCategories) {
								if(subCatId == subCategory.getSubCatId()) {
									subCategory.setCategory(catgry);
									subCategory.setSubCatName(subCategoryDeatils.getSubCatName());
									return subCatService.saveSubCategory(subCategory);
								}
							}
						}
					}
				} 
			}
		}
		return null;
	}
	
	@DeleteMapping("/location/{id}/department/{did}/category/{cid}/subcategory/{sid}")
	public int deleteSubCategoryById(@PathVariable(value="id") int locId, @PathVariable(value="did") int deptId, 
			@PathVariable(value="cid") int catId, @PathVariable(value="sid") int subCatId) {
		Optional<Location> loc = locService.getLocationById(locId);
		if(loc.get() != null) {
			Set<Department> depts = loc.get().getDepartments();
			for (Department department : depts) {
				if(deptId == department.getDeptId()) {
					List<Category> catagories = catService.getAllCategoriesByDeptId(deptId);
					for (Category category : catagories) {
						if(catId == category.getCatId()) {
							SubCategory sourseSubCat = null;
							List<SubCategory> subCategories = subCatService.getAllSubCategoriesByCatId(catId);
							for (SubCategory subCategory : subCategories) {
								if(subCatId == subCategory.getSubCatId()) {
									sourseSubCat = subCategory;
									subCatService.deleteSubCategory(subCategory);
								}
							}
							if(subCatService.getAllSubCategoriesByCatId(catId).contains(sourseSubCat)) {
								return 0;
							}
						}
					}
				} 
			}
		}
		return 1;
	}
}
