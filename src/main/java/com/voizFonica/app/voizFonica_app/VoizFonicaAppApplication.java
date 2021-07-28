package com.voizFonica.app.voizFonica_app;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class VoizFonicaAppApplication {
	private static UserOrderService userOrderService = new UserOrderService();
	
	
	private static LocalDate today = LocalDate.now();

	public static void main(String[] args) {
		SpringApplication.run(VoizFonicaAppApplication.class, args);
		while(true) {
			LocalDate currentDate = LocalDate.now();
			if(String.valueOf(currentDate).equals(String.valueOf(today.plusDays(1)))) {
				userOrderService.madePlansExpired();
				today = currentDate;
			}
			
		}
	}

}
