package com.rest.template.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.template.main.model.ProductDto;
import com.rest.template.main.service.ProductClientService;


@RestController
@RequestMapping("/product/client")
public class ProductClientController {
	
	
	@Autowired private ProductClientService productService;
	
	@PostMapping
	public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto)
	{
		ProductDto savedProduct = productService.createProduct(productDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateProduct(@PathVariable String id, @RequestBody ProductDto productDto)
	{
	    productService.updateProduct(id, productDto);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Updated successfully");
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable String id)
	{
		productService.deleteProduct(id);
		
		return ResponseEntity.status(HttpStatus.OK).body("Product Id deleted Successfully");
	}
	// http://localhost:8083/product/client/prod/d72d8b93-df4f-4b8d-8986-7f0c1059ad4c
	@GetMapping("/{id}")
	public ResponseEntity<ProductDto> getProductById(@PathVariable String id)
	{
		ProductDto productDto = productService.getProductById(id);
		
		return new ResponseEntity<>(productDto, HttpStatus.OK);
	}
	
	
	

}
