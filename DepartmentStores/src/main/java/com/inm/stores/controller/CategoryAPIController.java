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
import com.inm.stores.service.CategoryService;
import com.inm.stores.service.DepartmentService;
import com.inm.stores.service.LocationService;

@RestController
@RequestMapping("/api/v1")
@Produces("application/json")
@CrossOrigin
public class CategoryAPIController {

	@Autowired
	LocationService locService;
	
	@Autowired
	DepartmentService deptService;
	
	@Autowired
	CategoryService catService;
	
	@GetMapping("/location/{id}/department/{did}/category")
	public List<Category> getCategories(@PathVariable(value="id") int locId, @PathVariable(value="did") int deptId) {
		Optional<Location> loc = locService.getLocationById(locId);
		if(loc.get() != null) {
			Set<Department> depts = loc.get().getDepartments();
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
			Set<Department> depts = loc.get().getDepartments();
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
			Set<Department> depts = loc.get().getDepartments();
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
			Set<Department> depts = loc.get().getDepartments();
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
	public int deleteCategoryById(@PathVariable(value="id") int locId, @PathVariable(value="did") int deptId,
			@PathVariable(value="cid") int catId) {
		Optional<Location> loc = locService.getLocationById(locId);
		if(loc.get() != null) {
			Set<Department> depts = loc.get().getDepartments();
			for (Department department : depts) {
				if(deptId == department.getDeptId()) {
					Optional<Category> cat = catService.getCategoryById(catId);
					if(cat.get() != null) {
						catService.deleteCategory(cat.get());
						if(!catService.getCategoryById(catId).isPresent()) {
							return 1;
						}
					}
				} 
			}
		}
		return 0;
	}
	
}
