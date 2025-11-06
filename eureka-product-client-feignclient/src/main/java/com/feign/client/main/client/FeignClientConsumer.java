package com.feign.client.main.client;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.feign.client.main.model.ProductDto;



@FeignClient(name = "PRODUCT-SERVICE")
public interface FeignClientConsumer {
	
	@PostMapping("/products/product")
	public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto);
	
	@PutMapping("/products/product/{id}")
	public ResponseEntity<String> updateProduct(@PathVariable String id, @RequestBody ProductDto productDto);
	
	@DeleteMapping("/products/product/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable String id);
	
	@GetMapping("/products/product/{id}")
	public ResponseEntity<ProductDto> getProductById(@PathVariable String id);

}
