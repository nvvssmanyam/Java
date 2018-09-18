package com.inm.stores.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.inm.stores.entities.Department;
import com.inm.stores.entities.Location;

public interface LocationService {
	
	Location saveLocation(Location location);
	
	Location updateLocation(int locId, Location location);
	
	void deleteLocation(Location location);
	
	int deleteLocationById(int locId);
	
	Optional<Location> getLocationById(int id);
	
	List<Location> getAllLocation();
	
	Set<Department> getDepartmentsByLocation(int id);
	
	Set<Department> getAllDepartments();
	
	int isLocationExist(int id);

}
