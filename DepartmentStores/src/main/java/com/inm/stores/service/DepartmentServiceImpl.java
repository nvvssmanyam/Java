package com.inm.stores.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inm.stores.entities.Category;
import com.inm.stores.entities.Department;
import com.inm.stores.repos.DepartmentRepo;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentRepo deptRepository;

	public DepartmentRepo getDeptRepository() {
		return deptRepository;
	}

	public void setDeptRepository(DepartmentRepo deptRepository) {
		this.deptRepository = deptRepository;
	}

	@Override
	public Department saveDepartment(Department department) {
		return deptRepository.save(department);
	}

	@Override
	public Department updateDepartment(Department department) {
		return deptRepository.save(department);
	}

	@Override
	public void deleteDepartment(Department department) {
		deptRepository.delete(department);
		
	}

	@Override
	public Optional<Department> getDepartmentById(int id) {
		return deptRepository.findById(id);
	}

	@Override
	public List<Department> getAllDepartments() {
		return (List<Department>) deptRepository.findAll();
	}

	@Override
	public List<Category> getCategoryByDeptId(int id) {
		return null;
	}



}
