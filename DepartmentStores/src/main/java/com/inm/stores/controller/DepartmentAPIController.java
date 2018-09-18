package com.inm.stores.controller;

import java.util.List;
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

import com.inm.stores.entities.Department;
import com.inm.stores.service.DepartmentService;
import com.inm.stores.service.LocationService;

@RestController
@RequestMapping("/api/v1/location/{id}/department")
@Produces("application/json")
@CrossOrigin
public class DepartmentAPIController {

	@Autowired
	LocationService locService;
	
	@Autowired
	DepartmentService deptService;
	
	@GetMapping()
	public Set<Department> getDepartments(@PathVariable(value="id") int locId) {
		return locService.getDepartmentsByLocation(locId);
	}
	
	@PostMapping()
	public Set<Department> createDepartment(@PathVariable(value="id") int locId, 
			@Valid @RequestBody Department department) {
		return deptService.saveDepartment(locId, department);
	}
	
	@GetMapping("/{did}")
	public List<Department> getDepartmentsById(@PathVariable(value="id") int locId, 
			@PathVariable(value="did") int deptId) {
		return deptService.getDepartmentById(locId, deptId);
	}
	
	@PutMapping("/{did}")
	public Department updateDepartment(@PathVariable(value="id") int locId, 
			@PathVariable(value="did") int deptId, @Valid @RequestBody Department departmentDeatils) {
		return deptService.updateDepartment(locId, deptId, departmentDeatils);
	}
	
	@DeleteMapping("/{did}")
	public int deleteDepartment(@PathVariable(value="id") int locId, 
			@PathVariable(value="did") int deptId) {
		return deptService.deleteDepartment(locId, deptId);
	}
}
