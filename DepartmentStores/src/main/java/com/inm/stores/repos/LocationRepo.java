package com.inm.stores.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inm.stores.entities.Location;

@Repository
public interface LocationRepo extends JpaRepository<Location, Integer> {

}
