package com.inm.stores.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.inm.stores.entities.Department;

@Repository
public interface DepartmentRepo extends CrudRepository<Department, Integer> {

	@Query(value = "SELECT * FROM department d, dept_locations dl where d.dept_id=dl.dept_id and dl.loc_id=:locId", nativeQuery = true)
	List<Department> find(@Param("locId") int locId);
}
