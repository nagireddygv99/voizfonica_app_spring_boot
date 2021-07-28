package com.voizFonica.app.voizFonica_app;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_product")
public class UserProduct {
	@Id
	@Column(name="user_product_no")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userProductNo;
	@Column(name="user_phone_number")
	private String userPhoneNumber;
	@Column(name="product_id")
	private int productId;
	@Column(name="user_number")
	private String userNumber;
	
	public UserProduct() {}

	public UserProduct(String userPhoneNumber, int productId, String userNumber,Integer userProductNo) {
		super();
		this.userPhoneNumber = userPhoneNumber;
		this.productId = productId;
		this.userNumber = userNumber;
		this.userProductNo = userProductNo;
	}

	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}

	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(String userNumber) {
		this.userNumber = userNumber;
	}

	public Integer getUserProductNo() {
		return userProductNo;
	}

	public void setUserProductNo(Integer userProductNo) {
		this.userProductNo = userProductNo;
	}
	
	
}
