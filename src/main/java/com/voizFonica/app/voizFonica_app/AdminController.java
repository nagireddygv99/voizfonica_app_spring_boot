package com.voizFonica.app.voizFonica_app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/admin/get-admin/{adminUserName}")
	public ResponseEntity<Admin> getAdminByUserName(@PathVariable String adminUserName) {
		try {
			Admin admin = adminService.getAdmin(adminUserName);
			if(admin!=null) {
				return new ResponseEntity<Admin>(admin,HttpStatus.OK);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
