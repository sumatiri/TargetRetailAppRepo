package com.retailapplication.model;


/* Model class for ProductInfo db. Since target provided url is not working using custom
 * api to find product name. This db contains only Product name and Id. This is dummy
 * for fetching product name from the URL
 * 
 */

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="productinfo")
public class ProductInfo {
	@Id
	private int id;
	 
	private String name;
	
	public ProductInfo(){
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "ProductName {"
			+ "name=" + name  + "}";
	}
	
}
