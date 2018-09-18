package com.inm.stores.repos;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.inm.stores.entities.Category;
import com.inm.stores.entities.Department;

@Repository
public interface DepartmentRepo extends CrudRepository<Department, Integer> {

	@Query(value = "SELECT * FROM department d, dept_locations dl where d.dept_id=dl.dept_id and dl.loc_id=:locId", nativeQuery = true)
	Set<Department> find(@Param("locId") int locId);
	
	@Query(value = "SELECT d.* FROM department d, dept_locations dl where d.dept_id=dl.dept_id", nativeQuery = true)
	Set<Department> findAllDepts();
	
	@Query(value = "SELECT * FROM department d, category c where d.dept_id=c.dpt_id and d.dept_id=:deptId", nativeQuery = true)
	List<Category> findAllCategories(@Param("deptId") int deptId);
	
	@Query(value = "SELECT COUNT(*) FROM department d where d.dept_id=:deptId", nativeQuery = true)
	int isRecordExist(@Param("deptId") int deptId);
}
