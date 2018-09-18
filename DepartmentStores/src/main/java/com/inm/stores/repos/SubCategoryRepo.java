package com.inm.stores.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.inm.stores.entities.SubCategory;

@Repository
public interface SubCategoryRepo extends JpaRepository<SubCategory, Integer>{

	@Query(value = "SELECT * FROM subcategory s where s.cat_id=:catId", nativeQuery = true)
	List<SubCategory> find(@Param("catId") int catId);
	
	@Query(value = "SELECT COUNT(*) FROM subcategory s where s.subcat_id=:subCatId", nativeQuery = true)
	int isRecordExist(@Param("subCatId") int subCatId);
	
}
