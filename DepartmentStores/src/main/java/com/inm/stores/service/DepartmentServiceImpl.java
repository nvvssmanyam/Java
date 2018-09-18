package com.inm.stores.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inm.stores.entities.Category;
import com.inm.stores.entities.Department;
import com.inm.stores.entities.Location;
import com.inm.stores.repos.DepartmentRepo;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentRepo deptRepository;
	
	@Autowired
	private LocationService locService;

	public DepartmentRepo getDeptRepository() {
		return deptRepository;
	}

	public void setDeptRepository(DepartmentRepo deptRepository) {
		this.deptRepository = deptRepository;
	}

	@Override
	public Set<Department> saveDepartment(int locId, Department department) {
		
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

	@Override
	public Department updateDepartment(int locId, int deptId, Department departmentDetails) {
		Optional<Location> loc = locService.getLocationById(locId);
		if(loc.get() != null) {
			Set<Department> depts = loc.get().getDepartments();
			for (Department department : depts) {
				if(deptId == department.getDeptId()) {
					department.setDeptName(departmentDetails.getDeptName());
					return deptRepository.save(department);
				}
			}
		}
		return null;
	}

	@Override
	public int deleteDepartment(int locId, int deptId) {

		deptRepository.deleteById(deptId);
		if(isDepartmentExist(deptId) == 0 ) {
			return 1;
		} 
		return 0;
	}

	@Override
	public List<Department> getDepartmentById(int locId, int deptId) {
		
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
	
	@Override
	public Optional<Department> getDepartmentByDeptId(int deptId){
		return deptRepository.findById(deptId);
	}

	@Override
	public List<Department> getAllDepartments() {
		return (List<Department>) deptRepository.findAll();
	}

	@Override
	public List<Category> getCategoryByDeptId(int id) {
		return deptRepository.findAllCategories(id);
	}

	public int isDepartmentExist(int deptId) {
		return deptRepository.isRecordExist(deptId);
	}

}
