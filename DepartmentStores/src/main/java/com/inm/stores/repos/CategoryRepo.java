package com.inm.stores.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.inm.stores.entities.Category;

@Repository
public interface CategoryRepo extends CrudRepository<Category, Integer>{

	@Query(value = "SELECT * FROM category c where c.dpt_id=:deptId", nativeQuery = true)
	List<Category> find(@Param("deptId") int dptId);
	
	@Query(value = "SELECT COUNT(*) FROM category c where c.cat_id=:catId", nativeQuery = true)
	int isRecordExist(@Param("catId") int catId);
}
