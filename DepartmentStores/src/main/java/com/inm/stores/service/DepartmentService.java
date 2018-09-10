package com.inm.stores.service;

import java.util.List;
import java.util.Optional;

import com.inm.stores.entities.Category;
import com.inm.stores.entities.Department;

public interface DepartmentService {
	
	Department saveDepartment(Department department);
	
	Department updateDepartment(Department department);
	
	void deleteDepartment(Department department);
	
	Optional<Department> getDepartmentById(int id);
	
	List<Department> getAllDepartments();
	
	List<Category> getCategoryByDeptId(int id);

}
