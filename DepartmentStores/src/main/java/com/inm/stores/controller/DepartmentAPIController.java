package com.inm.stores.controller;

import java.util.ArrayList;
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

import com.inm.stores.entities.Department;
import com.inm.stores.entities.Location;
import com.inm.stores.service.DepartmentService;
import com.inm.stores.service.LocationService;

@RestController
@RequestMapping("/api/v1")
@Produces("application/json")
@CrossOrigin
public class DepartmentAPIController {

	@Autowired
	LocationService locService;
	
	@Autowired
	DepartmentService deptService;
	
	@GetMapping("/location/{id}/department")
	public List<Department> getDepartments(@PathVariable(value="id") int locId) {
		Optional<Location> loc = locService.getLocationById(locId);
		if(loc.get() != null) {
			return new ArrayList(loc.get().getDepartments());
		}
		return null;
	}
	
	@PostMapping("/location/{id}/department")
	public Set<Department> createDepartment(@PathVariable(value="id") int locId, 
			@Valid @RequestBody Department department) {
		Optional<Location> loc = locService.getLocationById(locId);
		Location location = loc.get();
		if(location != null) {
			//deptList - Department with location id
			Set<Department> deptListWithId = locService.getDepartmentsByLocation(locId);
			if(!deptListWithId.contains(department)) {
				Set<Department> allDeptList = locService.getAllDepartments();
				if(allDeptList.contains(department)) {
					for (Department dept : allDeptList) {
						if(dept.equals(department)) {
							deptListWithId.add(dept);
						}
					}
				} else {
					deptListWithId.add(department);
				}
			}

			location.setDepartments(deptListWithId);
			locService.saveLocation(location);
			return locService.getDepartmentsByLocation(locId);
		}
		return null;
	}
	
	@GetMapping("/location/{id}/department/{did}")
	public List<Department> getDepartmentsById(@PathVariable(value="id") int locId, 
			@PathVariable(value="did") int deptId) {
		Optional<Location> loc = locService.getLocationById(locId);
		if(loc.get() != null) {
			Set<Department> depts = loc.get().getDepartments();
			List<Department> deptsWithId = new ArrayList<>();
			for (Department department : depts) {
				if(deptId == department.getDeptId()) {
					deptsWithId.add(department);
				}
			}
			return deptsWithId;
		}
		return null;
	}
	
	@PutMapping("/location/{id}/department/{did}")
	public Department updateDepartment(@PathVariable(value="id") int locId, 
			@PathVariable(value="did") int deptId, @Valid @RequestBody Department departmentDeatils) {
		Optional<Location> loc = locService.getLocationById(locId);
		if(loc.get() != null) {
			Set<Department> depts = loc.get().getDepartments();
			for (Department department : depts) {
				if(deptId == department.getDeptId()) {
					department.setDeptName(departmentDeatils.getDeptName());
					return deptService.saveDepartment(department);
				}
			}
		}
		return null;
	}
	
	@DeleteMapping("/location/{id}/department/{did}")
	public int deleteDepartment(@PathVariable(value="id") int locId, 
			@PathVariable(value="did") int deptId) {
		Optional<Location> loc = locService.getLocationById(locId);
		if(loc.get() != null) {
			Set<Department> depts = loc.get().getDepartments();
			Department source = null;
			for (Department department : depts) {
				if(deptId == department.getDeptId()) {
					source = department;
					deptService.deleteDepartment(department);
				}
			}
			if(depts.contains(source)) {
				return 0;
			}
		}
		return 1;
	}
}
