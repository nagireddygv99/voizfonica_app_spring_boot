package com.voizFonica.app.voizFonica_app;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ADMIN")
public class Admin {
	@Id
	@Column(name="admin_user_name")
	private String adminUserName;
	@Column(name="admin_name")
	private String adminName;
	@Column(name="admin_password")
	private String adminPassword;
	
	public Admin() {}
	public Admin(String adminUserName, String adminName, String adminPassword) {
		super();
		this.adminUserName = adminUserName;
		this.adminName = adminName;
		this.adminPassword = adminPassword;
	}
	
	public String getAdminUserName() {
		return adminUserName;
	}
	public void setAdminUserName(String adminUserName) {
		this.adminUserName = adminUserName;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	
	
	
}
