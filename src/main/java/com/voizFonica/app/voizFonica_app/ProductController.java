package com.voizFonica.app.voizFonica_app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@GetMapping("/product/get-all-products")
	public List<Products> getAllProducts() {
		return productService.findAll();
	}
	
	@GetMapping("/product/get-product-by-product-name/{productName}")
	public ResponseEntity<Products> getProductDataByName(@PathVariable String productName) {
		try {
			Products product = productService.findByProductName(productName);
			return new ResponseEntity<Products>(product,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
		
}
