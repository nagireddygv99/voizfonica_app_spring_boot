package com.voizFonica.app.voizFonica_app;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PLAN")
public class Plans {
	
	@Id
	@Column(name="plan_id")
	private int planId;
	
	@Column(name="plan_amount")
	private double planAmount;
	
	@Column(name="plan_description")
	private String planDescription;
	
	@Column(name="plan_duration")
	private int planDuration;
	
	@Column(name="product_id")
	private int productId;
	
	public Plans() {
		
	}

	public Plans(int planId, double planAmount, String planDescription, int planDuration, int productId) {
		super();
		this.planId = planId;
		this.planAmount = planAmount;
		this.planDescription = planDescription;
		this.planDuration = planDuration;
		this.productId = productId;
	}

	public int getPlanId() {
		return planId;
	}

	public void setPlanId(int planId) {
		this.planId = planId;
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

	public int getPlanDuration() {
		return planDuration;
	}

	public void setPlanDuration(int planDuration) {
		this.planDuration = planDuration;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

}
