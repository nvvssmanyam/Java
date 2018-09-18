package com.inm.stores.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.inm.stores.entities.Category;
import com.inm.stores.entities.Department;

public interface DepartmentService {
	
	Set<Department> saveDepartment(int locId, Department department);
	
	Department updateDepartment(int locId, int deptId, Department department);
	
	int deleteDepartment(int locId, int deptId);
	
	List<Department> getDepartmentById(int locId, int deptId);
	
	Optional<Department> getDepartmentByDeptId(int deptId);
	
	List<Department> getAllDepartments();
	
	List<Category> getCategoryByDeptId(int id);
	
	int isDepartmentExist(int id);

}
