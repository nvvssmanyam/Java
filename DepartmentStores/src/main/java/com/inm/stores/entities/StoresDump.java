package com.inm.stores.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="storesdump")
public class StoresDump {

	@Id
	private int sku;
	private String name;
	private String location;
	private String department;
	private String category;
	@Column(name="subcategory")
	private String subCategory;
	
	public int getSku() {
		return sku;
	}
	public void setSku(int sku) {
		this.sku = sku;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public StoresDump() {

	}
	public StoresDump(int sku, String name, String location, String department, String category, String subCategory) {
		super();
		this.sku = sku;
		this.name = name;
		this.location = location;
		this.department = department;
		this.category = category;
		this.subCategory = subCategory;
	}
	@Override
	public String toString() {
		return "StoresDump [sku=" + sku + ", name=" + name + ", location=" + location + ", department=" + department
				+ ", category=" + category + ", subCategory=" + subCategory + "]";
	}
	
	
}
