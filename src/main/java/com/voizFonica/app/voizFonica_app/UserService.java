package com.voizFonica.app.voizFonica_app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;
	
	public List<Users> findAll() {
		return userRepo.findAll();
	}
	
	public Users findByMobileNumber(String phoneNumber) {
		return userRepo.findById(phoneNumber).get();
	}
	
	public void saveUser(Users user) {
		userRepo.save(user);
	}
	
}
