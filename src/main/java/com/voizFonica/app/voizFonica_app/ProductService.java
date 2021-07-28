package com.voizFonica.app.voizFonica_app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepo;
	
	public List<Products> findAll() {
		return productRepo.findAll();
	}
	
	public Products findByProductName(String productName) {
		return productRepo.findByProductName(productName);
	}	
}

