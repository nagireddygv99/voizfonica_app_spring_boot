package com.voizFonica.app.voizFonica_app;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class EmailSenderController {
	@Autowired
	private EmailSender emailSender;
	@Autowired
	private UserService userService;
	
	@GetMapping("mail/getMail/{userPhoneNumber}")
	public ResponseEntity<Otp> getOtp(@PathVariable String userPhoneNumber) {
		Otp otp = new Otp();
		try {
			Users user = userService.findByMobileNumber(userPhoneNumber);
			otp.setEmail(user.getUserEmailId());
			otp.generateOtp();
			emailSender.sendEmail(otp.getEmail(),otp.getOtp());
			return new ResponseEntity<Otp>(otp,HttpStatus.OK);
		}
		catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Otp>(otp,HttpStatus.OK);
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}


class Otp {
	private String email;
	private Integer otp;
	
	public Otp() {}

	public Integer getOtp() {
		return otp;
	}
	
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void generateOtp() {
		Random random = new Random();
		otp = random.nextInt(10000);
		if(otp<0) {
			otp*=-1;
		}
		if(otp<1000) {
			otp+=1000;
		}
	}
	
	
}
