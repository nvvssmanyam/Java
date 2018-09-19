package com.inm.stores.entities;

import java.util.Set;

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
	
	
	@Column(name="loc_name", nullable=false)
	private String locName;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, fetch=FetchType.EAGER, targetEntity=Department.class)
	@JoinTable(
			name="dept_locations",
			joinColumns= {@JoinColumn(name="loc_id")}, 
			inverseJoinColumns = {@JoinColumn(name="dept_id")})
	Set<Department> departments;
	
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
	public Set<Department> getDepartments() {
		return departments;
	}
	public void setDepartments(Set<Department> departments) {
		this.departments = departments;
	}
	
	public Location() {

	}
	public Location(String locName, Set<Department> departments) {
		super();
		this.locName = locName;
		this.departments = departments;
	}
	@Override
	public String toString() {
		return "Location [locId=" + locId + ", locName=" + locName + ", departments=" + departments + "]";
	}
	
}
