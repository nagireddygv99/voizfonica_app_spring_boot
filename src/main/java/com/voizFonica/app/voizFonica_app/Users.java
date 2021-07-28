package com.voizFonica.app.voizFonica_app;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.Table;





@Entity
@Table(name = "USERS")
public class Users {
	
	@Id
	@Column(name="user_phone_number")
	private String userPhoneNumber;
	
	@Column(name="user_email_id")
	private String userEmailId;
	
	@Column(name="user_first_name")
	private String userFirstName;
	
	@Column(name="user_last_name")
	private String userLastName;
	
	@Column(name="user_password")
	private String userPassword;
	
	public Users() {}

	public Users(String userPhoneNumber, String userEmailId, String userFirstName, String userLastName,
			String userPassword) {
		super();
		this.userPhoneNumber = userPhoneNumber;
		this.userEmailId = userEmailId;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userPassword = userPassword;
	}
	
	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}

	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}
	
	public String getUserEmailId() {
		return userEmailId;
	}
	
	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}
	
	
	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}
	
	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}
	
	
	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	

}
