package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductServices implements ProductInterface {

	@Autowired
	ProductRepository prodRepo;

	@Override
	public Product saveProduct(Product product) {
		
		float profit = 0.15f;
		profit = product.getCostPrice() * profit ;
		product.setProfit(profit);
		
		int sellPrice = product.getCostPrice() + (int)profit;
		product.setSellPrice(sellPrice);
		
		float gst = 0.18f;
		gst = sellPrice * gst;
		product.setGst(gst);
		
		int amount = product.getQuantity();
		amount = amount * (sellPrice + (int)gst);
		product.setAmount(amount);

		
		return prodRepo.save(product);
	}

	
	@Override
	public List<Product> getAllProducts() {
		return prodRepo.findAll();
	}

	@Override
	public ResponseEntity<?> getProduct(int pid){
		Optional<Product> prod = prodRepo.findById(pid);
		
		if(prod.isPresent()) {
			return ResponseEntity.ok(prod.get());
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					             .body("Product doesn't exist");
		}
	}

    @Override
    public ResponseEntity<String> delete(int pid){
    	if(!prodRepo.existsById(pid)) {
    		return ResponseEntity.status(HttpStatus.NOT_FOUND)
    				             .body("Product doesn't exist");
    	}
    	prodRepo.deleteById(pid);
    	return ResponseEntity.ok("Product Deleted Successfully");
    }
	
	
	private void productDetails(Product product) {
	    float profit = 0.15f; 
	    profit = product.getCostPrice() * profit;
	    product.setProfit(profit);
	    
	    int sellPrice = product.getCostPrice() + (int) profit;
	    product.setSellPrice(sellPrice);
	    
	    float gst = 0.18f;
	    gst = sellPrice * gst;
	    product.setGst(gst);
	    
	    int quantity = product.getQuantity();
	    int amount = quantity * (sellPrice + (int) gst);
	    product.setAmount(amount);
	}


	@Override
	public Product updateProduct(int pid, Product product) {
		Product update = prodRepo.findById(pid) 
				.orElseThrow(() -> new RuntimeException("Product Not Found with id: "+pid));
		
		update.setName(product.getName());
		update.setImage(product.getImage());
		update.setOrigin(product.getOrigin());
		update.setQuantity(product.getQuantity());
		update.setCostPrice(product.getCostPrice());

		productDetails(update);
		
		return prodRepo.save(update);
	}
	
	
	
}
