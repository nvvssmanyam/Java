package com.inm.stores.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cat_id")
	private int catId;
	
	@Column(name="cat_name")
	private String catName;
	
	@ManyToOne
	@JoinColumn(name="dpt_id")
	@JsonIgnore
	private Department department;
	
	@OneToMany(mappedBy="category")
	@JsonIgnore
	private List<SubCategory> subCategories;

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<SubCategory> getSubCategories() {
		return subCategories;
	}

	public void setSubCategories(List<SubCategory> subCategories) {
		this.subCategories = subCategories;
	}

	
	
	public Category() {

	}

	public Category(String catName, Department department) {
		this.catName = catName;
		this.department = department;
	}
	
}
