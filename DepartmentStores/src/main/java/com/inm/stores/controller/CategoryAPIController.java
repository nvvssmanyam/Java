package com.inm.stores.controller;

import java.util.List;
import java.util.Optional;

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
import com.inm.stores.service.CategoryService;
import com.inm.stores.service.DepartmentService;
import com.inm.stores.service.LocationService;

@RestController
@RequestMapping("/api/v1/location/{id}/department/{did}/category")
@Produces("application/json")
@CrossOrigin
public class CategoryAPIController {

	@Autowired
	LocationService locService;
	
	@Autowired
	DepartmentService deptService;
	
	@Autowired
	CategoryService catService;
	
	@GetMapping()
	public List<Category> getCategories(@PathVariable(value="id") int locId, @PathVariable(value="did") int deptId) {
		return catService.getAllCategoriesByDeptId(deptId);
	}
	
	@GetMapping("/{cid}")
	public Optional<Category> getCategoryById(@PathVariable(value="id") int locId, @PathVariable(value="did") int deptId,
			@PathVariable(value="cid") int catId) {
		return catService.getCategoryById(catId);
	}
	
	@PostMapping()
	public Category createCategory(@PathVariable(value="id") int locId, @PathVariable(value="did") int deptId,
			@Valid @RequestBody Category category) {
		return catService.saveCategory(deptId, category);
	}
	
	@PutMapping("/{cid}")
	public Category updateCategory(@PathVariable(value="id") int locId, @PathVariable(value="did") int deptId,
			@PathVariable(value="cid") int catId,
			@Valid @RequestBody Category categoryDeatils) {
		return catService.updateCategory(deptId, catId, categoryDeatils);
	}
	
	@DeleteMapping("/{cid}")
	public int deleteCategoryById(@PathVariable(value="id") int locId, @PathVariable(value="did") int deptId,
			@PathVariable(value="cid") int catId) {
		return catService.deleteCategoryById(catId);
	}
	
}
