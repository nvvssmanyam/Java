package com.inm.stores.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="subcategory")
public class SubCategory {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="subcat_id")
	private int subCatId;
	
	@Column(name="subcat_name")
	private String subCatName;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cat_id")
	private Category category;

	public int getSubCatId() {
		return subCatId;
	}

	public void setSubCatId(int subCatId) {
		this.subCatId = subCatId;
	}

	public String getSubCatName() {
		return subCatName;
	}

	public void setSubCatName(String subCatName) {
		this.subCatName = subCatName;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
}
