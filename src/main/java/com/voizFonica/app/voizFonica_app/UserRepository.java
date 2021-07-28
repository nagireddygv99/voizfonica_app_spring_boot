package com.voizFonica.app.voizFonica_app;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<Users, String> {
	
}
