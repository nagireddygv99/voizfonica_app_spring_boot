package com.voizFonica.app.voizFonica_app;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT")
public class Products {
	@Id
	@Column(name="product_id")
	private int productId;
	
	@Column(name="product_name")
	private String productName;
	
	public Products() {
		
	}

	public Products(int productId, String productName) {
		super();
		this.productId = productId;
		this.productName = productName;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	

}
