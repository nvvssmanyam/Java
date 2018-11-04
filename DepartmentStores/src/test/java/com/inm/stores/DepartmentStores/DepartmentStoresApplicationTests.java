package com.inm.stores.DepartmentStores;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.inm.stores.entities.Category;
import com.inm.stores.entities.Department;
import com.inm.stores.entities.Location;
import com.inm.stores.entities.SubCategory;
import com.inm.stores.repos.CategoryRepo;
import com.inm.stores.repos.DepartmentRepo;
import com.inm.stores.repos.LocationRepo;
import com.inm.stores.repos.SubCategoryRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DepartmentStoresApplicationTests {
	
	@Autowired
	private LocationRepo locRepository;
	
	@Autowired
	private DepartmentRepo deptRepository;
	
	@Autowired
	private CategoryRepo catRepository;
	
	@Autowired
	private SubCategoryRepo subCatRepository;
	
	@Test
	public void test1CreateLocation() {
		
		Location l1 = new Location();
		l1.setLocName("Bangalore");
		locRepository.save(l1);
	}

	@Test
	public void test2CreateLocationWithDept() {
		
		Set<Department> depts = new HashSet<>();
		Department d1 = new Department();
		d1.setDeptName("Reliance");
		Department d2 = new Department();
		d2.setDeptName("DMart");
		depts.add(d1);
		depts.add(d2);
		
		Location l1 = new Location("Hyderabad", depts);
		locRepository.save(l1);
	}
	
	@Test
	public void test3CreateCategory() {
		List<Department> depts =  (List<Department>) deptRepository.findAll();
		Department dept = null;
		if(depts.size() > 0) {
			dept = depts.get(0);
			Category ctgry = new Category();
			ctgry.setCatName("Electronics");
			ctgry.setDepartment(dept);
			catRepository.save(ctgry);
		}
	}
	
	@Test
	public void test4CreateSubCategory() {
		List<Category> catgs =  (List<Category>) catRepository.findAll();
		Category cat = null;
		if(catgs.size() > 0) {
			cat = catgs.get(0);
			SubCategory subCtgry = new SubCategory();
			subCtgry.setSubCatName("Mobiles");
			subCtgry.setCategory(cat);
			subCatRepository.save(subCtgry);
		}
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
	public void testGetDepartments() {
		List<Department> depts =  (List<Department>) deptRepository.findAll();
		for (Department department : depts) {
			System.out.println(department);
		}
	}
	
}
