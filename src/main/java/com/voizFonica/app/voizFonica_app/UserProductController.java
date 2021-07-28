package com.voizFonica.app.voizFonica_app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class UserProductController {
	@Autowired
	private UserProductService userProductService;
	
	@GetMapping("user-product/get-user-product/{userPhoneNumber}")
	public List<UserProduct> getUserProductsOfUsers(@PathVariable String userPhoneNumber) {
		return userProductService.findAllById(userPhoneNumber);
	}
	
	@PostMapping("user-product/add-producct-to-user")
	public ResponseEntity<?> addProductToUser(@RequestBody UserProduct userProduct) {
		try {
			UserProduct exstUserProduct = userProductService.findByUserPhoneNumberAndUserNumber(userProduct.getUserPhoneNumber(), userProduct.getUserNumber());
			if(exstUserProduct != null) {
				return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
			}
			userProductService.saveProductToUser(userProduct);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch(Exception e) {
			userProductService.saveProductToUser(userProduct);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	
}
