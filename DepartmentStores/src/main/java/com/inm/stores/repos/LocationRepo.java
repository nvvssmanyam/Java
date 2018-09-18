package com.inm.stores.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.inm.stores.entities.Location;

@Repository
public interface LocationRepo extends JpaRepository<Location, Integer> {
	
	@Query(value = "SELECT COUNT(*) FROM location l where l.loc_id=:locId", nativeQuery = true)
	int isRecordExist(@Param("locId") int locId);

}
