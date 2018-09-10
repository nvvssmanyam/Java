package com.inm.stores.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inm.stores.entities.Department;
import com.inm.stores.entities.Location;
import com.inm.stores.repos.DepartmentRepo;
import com.inm.stores.repos.LocationRepo;

@Service
public class LocationServiceImpl implements LocationService {
	
	@Autowired
	private LocationRepo locRepository;
	
	@Autowired
	private DepartmentRepo deptRepository;

	@Override
	public Location saveLocation(Location location) {
		return locRepository.save(location);
	}

	@Override
	public Location updateLocation(Location location) {
		return locRepository.save(location);
	}

	@Override
	public void deleteLocation(Location location) {
		locRepository.delete(location);
	}

	@Override
	public Optional<Location> getLocationById(int id) {
		return locRepository.findById(id);
	}

	@Override
	public List<Location> getAllLocation() {
		return locRepository.findAll();
	}

	public LocationRepo getLocRepository() {
		return locRepository;
	}

	public void setLocRepository(LocationRepo locRepository) {
		this.locRepository = locRepository;
	}

	@Override
	public List<Department> getDepartmentsByLocation(int id) {
		return deptRepository.find(id);
	}

}
