package com.voizFonica.app.voizFonica_app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProductService {
	@Autowired
	private UserProductRepository userProductRepo;
	
	public List<UserProduct> findAllById(String userPhoneNumber) {
		return userProductRepo.findAllById(userPhoneNumber);
	}
	
	public void saveProductToUser(UserProduct userProduct) {
		userProductRepo.save(userProduct);
	}
	
	public UserProduct findByUserPhoneNumberAndUserNumber(String userPhoneNumber, String userNumber) {
		return userProductRepo.findUserProductIsExists(userPhoneNumber, userNumber);
	}
}
