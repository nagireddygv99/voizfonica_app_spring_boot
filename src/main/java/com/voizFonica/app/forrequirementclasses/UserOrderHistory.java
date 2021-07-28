package com.voizFonica.app.forrequirementclasses;

public class UserOrderHistory {
	private int orderId;
	private String userName;
	private String invoiceNumber;
	private String userPhoneNumber;
	private double planAmount;
	private int planDuration;
	private String planDescription;
	private String orderStatus;
	private String rechargedNumber;
	private String planActivationDate;
	private String planExpiryDate;
	public UserOrderHistory() {}
//	public UserOrderHistory(int orderId, double planAmount, String planDescription, String orderStatus) {
//		super();
//		this.orderId = orderId;
//		this.planAmount = planAmount;
//		this.planDescription = planDescription;
//		this.orderStatus = orderStatus;
//	}
	
	
	public UserOrderHistory(int orderId, double planAmount, String planDescription, String orderStatus,
			String rechargedNumber, String planActivationDate, String planExpiryDate,String userPhoneNumber,String userName,String invoiceNumber,int planDuration) {
		super();
		this.orderId = orderId;
		this.planAmount = planAmount;
		this.planDescription = planDescription;
		this.orderStatus = orderStatus;
		this.rechargedNumber = rechargedNumber;
		this.planActivationDate = planActivationDate;
		this.planExpiryDate = planExpiryDate;
		this.userPhoneNumber = userPhoneNumber;
		this.userName = userName;
		this.invoiceNumber = invoiceNumber;
		this.planDuration = planDuration;
	}
	
	
	public int getOrderId() {
		return orderId;
	}
	
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public double getPlanAmount() {
		return planAmount;
	}
	public void setPlanAmount(double planAmount) {
		this.planAmount = planAmount;
	}
	public String getPlanDescription() {
		return planDescription;
	}
	public void setPlanDescription(String planDescription) {
		this.planDescription = planDescription;
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


	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}


	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getInvoiceNumber() {
		return invoiceNumber;
	}


	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}


	public int getPlanDuration() {
		return planDuration;
	}


	public void setPlanDuration(int planDuration) {
		this.planDuration = planDuration;
	}
	
	
	
}
