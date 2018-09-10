package com.inm.stores.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.inm.stores.entities.Category;
import com.inm.stores.entities.Department;
import com.inm.stores.entities.Location;
import com.inm.stores.entities.SubCategory;
import com.inm.stores.service.CategoryService;
import com.inm.stores.service.DepartmentService;
import com.inm.stores.service.LocationService;
import com.inm.stores.service.SubCategoryService;

@Controller
@Produces("application/json")
public class StoresAPIController {

	@Autowired
	LocationService locService;
	
	@Autowired
	DepartmentService deptService;
	
	@Autowired
	CategoryService catService;
	
	@Autowired
	SubCategoryService subCatService;

	@GetMapping("/home")
	public ModelAndView loginMessage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("welcome");
		return model;
	}
	
	@GetMapping("/location")
	@ResponseBody
	public List<Location> getLocations(){
		return locService.getAllLocation();
	}
	
	@GetMapping("/location/{id}")
	@ResponseBody
	public Optional<Location> getLocation(@PathVariable(value="id") int locId) {
		return locService.getLocationById(locId);
	}
	
	@PostMapping("/location")
	@ResponseBody
	public Location createLocation(@Valid @RequestBody Location location) {
		return locService.saveLocation(location);
	}
	
	@PutMapping("/location/{id}") 
	public Location updateLocation(@PathVariable(value="id") int locId, 
			@Valid @RequestBody Location locationDetails) {
		Optional<Location> location = locService.getLocationById(locId);
		Location loc = location.get();
		
		loc.setLocId(locId);
		loc.setLocName(locationDetails.getLocName());
		loc.setDepartments(locationDetails.getDepartments());
		
		locService.saveLocation(loc);
		
		return loc;
		
	}
	
	@DeleteMapping("/location/{id}")
	public void deleteLocation(@PathVariable(value="id") int locId) {
		Optional<Location> loc = locService.getLocationById(locId);
		if(loc.get() != null) {
			locService.deleteLocation(loc.get());
		}
	}
	
	/*
	 *  Departmetn related APIs starts form here
	 */
	@GetMapping("/location/{id}/department")
	public List<Department> getDepartments(@PathVariable(value="id") int locId) {
		Optional<Location> loc = locService.getLocationById(locId);
		if(loc.get() != null) {
			return loc.get().getDepartments();
		}
		return null;
	}
	
	@PostMapping("/location/{id}/department")
	public Optional<Department> createDepartment(@PathVariable(value="id") int locId, @Valid @RequestBody Department department) {
		Optional<Location> loc = locService.getLocationById(locId);
		Location location = loc.get();
		if(location != null) {
			List<Department> deptList = locService.getDepartmentsByLocation(locId);
			deptList.add(department);
			location.setDepartments(deptList);
			locService.saveLocation(location);
			return deptService.getDepartmentById(department.getDeptId());
		}
		return null;
	}
	
	/*
	 *  Category related APIs Start from here
	 */
	@GetMapping("/location/{id}/department/{did}/category")
	public List<Category> getCategories(@PathVariable(value="id") int locId, @PathVariable(value="did") int deptId) {
		Optional<Location> loc = locService.getLocationById(locId);
		if(loc.get() != null) {
			List<Department> depts = loc.get().getDepartments();
			for (Department department : depts) {
				if(deptId == department.getDeptId()) {
					return catService.getAllCategoriesByDeptId(deptId);
				} 
			}
		}
		return null;
	}
	
	@GetMapping("/location/{id}/department/{did}/category/{cid}")
	public Optional<Category> getCategoryById(@PathVariable(value="id") int locId, @PathVariable(value="did") int deptId,
			@PathVariable(value="cid") int catId) {
		Optional<Location> loc = locService.getLocationById(locId);
		if(loc.get() != null) {
			List<Department> depts = loc.get().getDepartments();
			for (Department department : depts) {
				if(deptId == department.getDeptId()) {
					return catService.getCategoryById(catId);
				} 
			}
		}
		return null;
	}
	
	@PostMapping("/location/{id}/department/{did}/category")
	public Category createCategory(@PathVariable(value="id") int locId, @PathVariable(value="did") int deptId,
			@Valid @RequestBody Category category) {
		Optional<Location> loc = locService.getLocationById(locId);
		if(loc.get() != null) {
			List<Department> depts = loc.get().getDepartments();
			for (Department department : depts) {
				if(deptId == department.getDeptId()) {
					category.setDepartment(department);
					return catService.saveCategory(category);
				} 
			}
		}
		return null;
	}
	
	@PutMapping("/location/{id}/department/{did}/category/{cid}")
	public Category updateCategory(@PathVariable(value="id") int locId, @PathVariable(value="did") int deptId,
			@PathVariable(value="cid") int catId,
			@Valid @RequestBody Category categoryDeatils) {
		Optional<Location> loc = locService.getLocationById(locId);
		if(loc.get() != null) {
			List<Department> depts = loc.get().getDepartments();
			for (Department department : depts) {
				if(deptId == department.getDeptId()) {
					Optional<Category> category = catService.getCategoryById(catId);
					Category cat = category.get();
					cat.setCatName(categoryDeatils.getCatName());
					return catService.saveCategory(cat);
				} 
			}
		}
		return null;
	}
	
	@DeleteMapping("/location/{id}/department/{did}/category/{cid}")
	public void deleteCategoryById(@PathVariable(value="id") int locId, @PathVariable(value="did") int deptId,
			@PathVariable(value="cid") int catId) {
		Optional<Location> loc = locService.getLocationById(locId);
		if(loc.get() != null) {
			List<Department> depts = loc.get().getDepartments();
			for (Department department : depts) {
				if(deptId == department.getDeptId()) {
					Optional<Category> cat = catService.getCategoryById(catId);
					if(cat.get() != null) {
						catService.deleteCategory(cat.get());
					}
				} 
			}
		}
	}
	
	/*
	 *  SubCategory related APIs Start from here
	 */
	@GetMapping("/location/{id}/department/{did}/category/{cid}/subcategory")
	public List<SubCategory> getSubCategories(@PathVariable(value="id") int locId, @PathVariable(value="did") int deptId, 
			@PathVariable(value="cid") int catId) {
		Optional<Location> loc = locService.getLocationById(locId);
		if(loc.get() != null) {
			List<Department> depts = loc.get().getDepartments();
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
	public Optional<SubCategory> getSubCategoryById(@PathVariable(value="id") int locId, @PathVariable(value="did") int deptId, 
			@PathVariable(value="cid") int catId, @PathVariable(value="sid") int subCatId) {
		Optional<Location> loc = locService.getLocationById(locId);
		if(loc.get() != null) {
			List<Department> depts = loc.get().getDepartments();
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
			List<Department> depts = loc.get().getDepartments();
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
			List<Department> depts = loc.get().getDepartments();
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
	public void deleteSubCategoryById(@PathVariable(value="id") int locId, @PathVariable(value="did") int deptId, 
			@PathVariable(value="cid") int catId, @PathVariable(value="sid") int subCatId) {
		Optional<Location> loc = locService.getLocationById(locId);
		if(loc.get() != null) {
			List<Department> depts = loc.get().getDepartments();
			for (Department department : depts) {
				if(deptId == department.getDeptId()) {
					List<Category> catagories = catService.getAllCategoriesByDeptId(deptId);
					for (Category category : catagories) {
						if(catId == category.getCatId()) {
							List<SubCategory> subCategories = subCatService.getAllSubCategoriesByCatId(catId);
							for (SubCategory subCategory : subCategories) {
								if(subCatId == subCategory.getSubCatId()) {
									subCatService.deleteSubCategory(subCategory);
								}
							}
						}
					}
				} 
			}
		}
	}
}
