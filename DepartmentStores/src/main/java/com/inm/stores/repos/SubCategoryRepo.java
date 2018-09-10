package com.inm.stores.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.inm.stores.entities.SubCategory;

@Repository
public interface SubCategoryRepo extends CrudRepository<SubCategory, Integer>{

	@Query(value = "SELECT * FROM subcategory s where s.cat_id=:catId", nativeQuery = true)
	List<SubCategory> find(@Param("catId") int catId);
}
