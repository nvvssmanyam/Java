package com.inm.stores.entities;

import java.util.ArrayList;
import java.util.List;

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
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="dept_id")
	private int deptId;
	
	@Column(name="dept_name")
	private String deptName;
	
/*	@ManyToMany(cascade= {CascadeType.ALL}, fetch=FetchType.LAZY)
	@JoinTable(
			name="dept_locations", 
			joinColumns= {@JoinColumn(name="dept_id")}, 
			inverseJoinColumns = {@JoinColumn(name="loc_id")})*/
	
	@ManyToMany(fetch=FetchType.LAZY, mappedBy="departments")
	@JsonIgnore
	private List<Location> locations = new ArrayList<>();
	
	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="dpt_id")
	private List<Category> categories;

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public List<Location> getLocations() {
		return locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public Department(int deptId, String deptName) {
		this.deptId = deptId;
		this.deptName = deptName;
	}

	public Department() {
		
	}
	
}
