package com.inm.stores.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.inm.stores.entities.StoresDump;

@Repository
public interface StoresDumpRepo extends CrudRepository<StoresDump, Integer>{

	@Query(value = "SELECT * FROM storesdump s where s.location=:location and s.department=:department and s.category=:category and s.subcategory=:subCategory", nativeQuery = true)
	List<StoresDump> findByCategory(@Param("location")String location, @Param("department")String department, @Param("category") String category, @Param("subCategory") String subCategory);

}
