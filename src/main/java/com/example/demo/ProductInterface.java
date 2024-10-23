package com.example.demo;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface ProductInterface {

	public Product saveProduct(Product product);
	
	public List<Product> getAllProducts();
	
	public ResponseEntity<String> delete(int pid);
	
	public ResponseEntity<?> getProduct(int pid);
	
	public Product updateProduct(int pid, Product product);
}
