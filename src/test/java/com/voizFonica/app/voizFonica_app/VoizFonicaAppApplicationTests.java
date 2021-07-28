package com.voizFonica.app.voizFonica_app;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class VoizFonicaAppApplicationTests {

	@Autowired
	UserRepository userrepo;
	
	@Test
	void testForGetAllUsers() {
		List<Users> users = userrepo.findAll();
		assertTrue(!users.isEmpty());
	}
	@Test
	void testForInsertionOfData() {
		Users user = new Users();
		user.setUserPhoneNumber("9876543210");
		user.setUserEmailId("venkat@gmail.com");
		user.setUserFirstName("venkat");
		user.setUserLastName("venkat");
		user.setUserPassword("12345");
		try {
			userrepo.save(user);
			assertTrue(true);
		} catch(Exception e) {
			assertTrue(false);
		}
	}
	@Test
	void testForLogin() {
		Users userLog = new Users();
		userLog.setUserPhoneNumber("9963626105");
		userLog.setUserPassword("12345");
		try {
			Users user = userrepo.findById(userLog.getUserPhoneNumber()).get();
			if(user.getUserPassword().equals(userLog.getUserPassword())) {
				assertTrue(true);
			}
			else {
				assertTrue(false);
			}
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		
		
	}

}
