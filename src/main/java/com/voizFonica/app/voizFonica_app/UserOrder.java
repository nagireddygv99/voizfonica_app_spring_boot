package com.voizFonica.app.voizFonica_app;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_order1")
public class UserOrder {
	@Id
	@Column(name="order_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId;
	@Column(name="user_phone_number")
	private String userPhoneNumber;
	@Column(name="plan_id")
	private Integer planId;
	@Column(name="order_status")
	private String orderStatus;
	@Column(name="recharged_number")
	private String rechargedNumber;
	@Column(name="plan_activation_date")
	private String planActivationDate;
	@Column(name="plan_expiry_date")
	private String planExpiryDate;
	
	public UserOrder() {}

//	public UserOrder(Integer orderId, String userPhoneNumber, Integer planId, String orderStatus) {
//		super();
//		this.orderId = orderId;
//		this.userPhoneNumber = userPhoneNumber;
//		this.planId = planId;
//		this.orderStatus = orderStatus;
//	}
	
	

	

	public UserOrder(Integer orderId, String userPhoneNumber, Integer planId, String orderStatus, String rechargedNumber,
		String planActivationDate, String planExpiryDate) {
		super();
		this.orderId = orderId;
		this.userPhoneNumber = userPhoneNumber;
		this.planId = planId;
		this.orderStatus = orderStatus;
		this.rechargedNumber = rechargedNumber;
		this.planActivationDate = planActivationDate;
		this.planExpiryDate = planExpiryDate;
	}
	
	
	
	
	
	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}

	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}

	public Integer getPlanId() {
		return planId;
	}

	public void setPlanId(Integer planId) {
		this.planId = planId;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	
	
	
	
	
	

	public String getRechargedNumber() {
		return rechargedNumber;
	}

	public void setRechargedNumber(String rechargedNumber) {
		this.rechargedNumber = rechargedNumber;
	}

	public String getPlanActivationDate() {
		return planActivationDate;
	}

	public void setPlanActivationDate(String planActivationDate) {
		this.planActivationDate = planActivationDate;
	}

	public String getPlanExpiryDate() {
		return planExpiryDate;
	}

	public void setPlanExpiryDate(String planExpiryDate) {
		this.planExpiryDate = planExpiryDate;
	}
	
	
	
	
	
	
	
	
	
	
}
