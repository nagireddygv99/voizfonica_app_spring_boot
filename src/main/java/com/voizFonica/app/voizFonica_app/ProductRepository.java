package com.voizFonica.app.voizFonica_app;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Products, String> {
	
  public Products findByProductName(String productName);

}
