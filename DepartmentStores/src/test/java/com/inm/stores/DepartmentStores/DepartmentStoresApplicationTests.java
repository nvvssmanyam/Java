package com.inm.stores.DepartmentStores;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.inm.stores.entities.Category;
import com.inm.stores.entities.Department;
import com.inm.stores.entities.Location;
import com.inm.stores.repos.CategoryRepo;
import com.inm.stores.repos.DepartmentRepo;
import com.inm.stores.repos.LocationRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartmentStoresApplicationTests {
	
	@Autowired
	private LocationRepo locRepository;
	
	@Autowired
	private DepartmentRepo deptRepository;
	
	@Autowired
	private CategoryRepo catRepository;
	
	@Test
	public void testCreateLocation() {
		
		Location l1 = new Location(3, "BZA", null);
		locRepository.save(l1);
	}

	@Test
	public void testCreateLocationWithDept() {
		
		Set<Department> depts = new HashSet<>();
		Department d1 = new Department();
		d1.setDeptName("Grocery");
		depts.add(d1);
		
		Location l1 = new Location(2, "RJY", depts);
		locRepository.save(l1);
	}
	
	@Test
	public void testGetLocations() {
		List<Location> locations = new ArrayList<>();
		locations = locRepository.findAll();
		
		for (Location loc : locations) {
			System.out.println(loc);
		}
	}
	
	@Test
	public void testCreateCategory() {
		Optional<Department> dept = deptRepository.findById(4);
		if(dept.get() != null) {
			Category category = new Category("Milk", dept.get());
			catRepository.save(category);
		}
	}

}
