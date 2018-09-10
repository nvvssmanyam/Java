package com.inm.stores.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.inm.stores.entities.Department;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Location {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="loc_id")
	private int locId;
	
	@Column(name="loc_name")
	private String locName;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER, targetEntity=Department.class)
	@JoinTable(
			name="dept_locations",
			joinColumns= {@JoinColumn(name="loc_id")}, 
			inverseJoinColumns = {@JoinColumn(name="dept_id")})
	@JsonIgnore
	List<Department> departments = new ArrayList<>();
	
	public int getLocId() {
		return locId;
	}
	public void setLocId(int locId) {
		this.locId = locId;
	}
	public String getLocName() {
		return locName;
	}
	public void setLocName(String locName) {
		this.locName = locName;
	}
	public List<Department> getDepartments() {
		return departments;
	}
	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}
	
	public Location() {

	}
	public Location(int locId, String locName, List<Department> departments) {
		super();
		this.locId = locId;
		this.locName = locName;
		this.departments = departments;
	}
	@Override
	public String toString() {
		return "Location [locId=" + locId + ", locName=" + locName + ", departments=" + departments + "]";
	}
	
}
