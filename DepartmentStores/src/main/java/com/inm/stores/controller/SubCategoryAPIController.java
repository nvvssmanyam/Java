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

import com.inm.stores.entities.SubCategory;
import com.inm.stores.service.CategoryService;
import com.inm.stores.service.SubCategoryService;

@RestController
@RequestMapping("/api/v1/location/{id}/department/{did}/category/{cid}/subcategory")
@Produces("application/json")
@CrossOrigin
public class SubCategoryAPIController {
	
	@Autowired
	CategoryService catService;
	
	@Autowired
	SubCategoryService subCatService;
	
	@GetMapping()
	public List<SubCategory> getSubCategories(@PathVariable(value="id") int locId, @PathVariable(value="did") int deptId, 
			@PathVariable(value="cid") int catId) {
		return subCatService.getAllSubCategoriesByCatId(catId);
	}
	
	@GetMapping("/{sid}")
	public Optional<SubCategory> getSubCategoryByCatId(@PathVariable(value="id") int locId, @PathVariable(value="did") int deptId, 
			@PathVariable(value="cid") int catId, @PathVariable(value="sid") int subCatId) {
		return subCatService.getSubCategoryById(subCatId);
	}
	
	@PostMapping()
	public SubCategory createSubCategory(@PathVariable(value="id") int locId, @PathVariable(value="did") int deptId,
			@PathVariable(value="cid") int catId, @Valid @RequestBody SubCategory subCategory) {
		return subCatService.saveSubCategory(catId, subCategory);
	}
	
	@PutMapping("/{sid}")
	public SubCategory updateSubCategory(@PathVariable(value = "id") int locId, @PathVariable(value = "did") int deptId,
			@PathVariable(value = "cid") int catId, @PathVariable(value = "sid") int subCatId,
			@Valid @RequestBody SubCategory subCategoryDeatils) {
		
		return subCatService.updateSubCategory(catId, subCatId, subCategoryDeatils);
	}
	
	@DeleteMapping("/{sid}")
	public int deleteSubCategoryById(@PathVariable(value="id") int locId, @PathVariable(value="did") int deptId, 
			@PathVariable(value="cid") int catId, @PathVariable(value="sid") int subCatId) {
		return subCatService.deleteSubCategoryById(subCatId);
	}
}
