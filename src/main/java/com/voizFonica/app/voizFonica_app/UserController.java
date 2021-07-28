package com.voizFonica.app.voizFonica_app;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins="http://localhost:4200")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/user/get-all-users")
	public List<Users> getAllUsers() {
		return userService.findAll();
	}
	
	@GetMapping("/user/get-user-by-phone-number/{userPhoneNumber}")
	public ResponseEntity<Users> getUserDataById(@PathVariable String userPhoneNumber) {
		try {
			Users user = userService.findByMobileNumber(userPhoneNumber);
			return new ResponseEntity<Users>(user,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/user/registeruser")
	public ResponseEntity<?> saveUser(@RequestBody Users user) {
		try {
			Users userExists = userService.findByMobileNumber(user.getUserPhoneNumber());
			if(userExists!=null) {
				return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
			}
			userService.saveUser(user);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch(Exception e) {
			userService.saveUser(user);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	@PutMapping("/user/updateUser/{userPhoneNumber}")
	public ResponseEntity<?> updateUserInfo(@RequestBody Users user,@PathVariable String userPhoneNumber) {
		try {
			Users existUser = userService.findByMobileNumber(userPhoneNumber);
			existUser.setUserEmailId(user.getUserEmailId());
			existUser.setUserFirstName(user.getUserFirstName());
			existUser.setUserLastName(user.getUserLastName());
			existUser.setUserPassword(user.getUserPassword());
			userService.saveUser(existUser);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("user/changePassword/{userPhoneNumber}")
	public ResponseEntity<?> changePassword(@RequestBody Users user,@PathVariable String userPhoneNumber) {
		try {
			Users existUser = userService.findByMobileNumber(userPhoneNumber);
			existUser.setUserPassword(user.getUserPassword());
			userService.saveUser(existUser);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	
	
}
