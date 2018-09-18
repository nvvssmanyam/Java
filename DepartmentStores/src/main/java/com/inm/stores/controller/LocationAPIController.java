package com.inm.stores.controller;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import javax.ws.rs.Produces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inm.stores.entities.Location;
import com.inm.stores.service.LocationService;

@RestController
@RequestMapping("/api/v1/location")
@Produces("application/json")
@CrossOrigin
public class LocationAPIController {

	@Autowired
	LocationService locService;
	
	@GetMapping()
	public List<Location> getLocations(){
		return locService.getAllLocation();
	}
	
	@GetMapping("/{id}")
	public Optional<Location> getLocation(@PathVariable(value="id") int locId) {
		return locService.getLocationById(locId);
	}
	
	@PostMapping()
	public Location createLocation(@Valid @RequestBody Location location) {
		return locService.saveLocation(location);
	}
	
	@PutMapping("/{id}") 
	public Location updateLocation(@PathVariable(value="id") int locId, 
			@Valid @RequestBody Location locationDetails) {
		return locService.updateLocation(locId, locationDetails);
	}
	
	@DeleteMapping("/{id}")
	public int deleteLocation(@PathVariable(value="id") int locId) {
		return locService.deleteLocationById(locId);
	}
}
