package com.voizFonica.app.voizFonica_app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
	@Autowired
	private AdminRepository adminRepo;
	
	public Admin getAdmin(String adminUserName) {
		return adminRepo.findById(adminUserName).get();
	}
}
