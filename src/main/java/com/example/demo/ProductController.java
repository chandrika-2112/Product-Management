package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class ProductController {

	@Autowired
	private ProductServices service;
	
	@PostMapping("/save")
	public Product saveProduct(@RequestBody Product product) {
		return service.saveProduct(product);
	}
	
	@GetMapping("/allProducts")
	public List<Product> getAllProducts(){
		return service.getAllProducts();
	}
	
	 @DeleteMapping("/delete/{pid}")
	    public ResponseEntity<String> delete(@PathVariable int pid) {
	        ResponseEntity<String> response = service.delete(pid);
	        if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product doesn't exist");
	        }
	        return ResponseEntity.ok("Product Deleted Successfully...");
	    }

	    // Get a product by ID
	    @GetMapping("/product/{pid}")
	    public ResponseEntity<?> getProduct(@PathVariable int pid) {
	        ResponseEntity<?> response = service.getProduct(pid);
	        if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product doesn't exist");
	        }
	        return response;
	    }

	    // Update a product by ID
	    @PutMapping("/update/{pid}")
	    public ResponseEntity<?> updateProduct(@PathVariable int pid, @RequestBody Product product) {
	        Product updatedProduct = service.updateProduct(pid, product);
	        if (updatedProduct == null) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product doesn't exist");
	        }
	        return ResponseEntity.ok(updatedProduct);
	    }
	
}
