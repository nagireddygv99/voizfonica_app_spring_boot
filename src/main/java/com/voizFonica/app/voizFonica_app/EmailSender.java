package com.voizFonica.app.voizFonica_app;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Service
public class EmailSender {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	public void sendEmail(String mailId,Integer otp) {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(mailId);
		msg.setSubject("VoizFonica Verification");
		msg.setText("Forgot password verification code is "+otp);
		
		javaMailSender.send(msg);
		
	}
}
