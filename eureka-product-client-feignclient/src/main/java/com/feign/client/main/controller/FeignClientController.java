package com.feign.client.main.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.feign.client.main.model.ProductDto;
import com.feign.client.main.service.FeignClientService;


@RestController
public class FeignClientController {
	
	
	@Autowired private FeignClientService feignClientService;
	
	
	@PostMapping("/prod")
	public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto)
	{
		ProductDto savedProduct = feignClientService.createProduct(productDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
	}
	
	@PutMapping("/prod/{id}")
	public ResponseEntity<String> updateProduct(@PathVariable String id, @RequestBody ProductDto productDto)
	{
		feignClientService.updateProduct(id, productDto);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Updated successfully");
	}
	
	@DeleteMapping("/prod/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable String id)
	{
		feignClientService.deleteProduct(id);
		
		return ResponseEntity.status(HttpStatus.OK).body("Product Id deleted Successfully");
	}
	// http://localhost:8083/product/client/prod/d72d8b93-df4f-4b8d-8986-7f0c1059ad4c
	@GetMapping("/prod/{id}")
	public ResponseEntity<ProductDto> getProductById(@PathVariable String id)
	{
		ProductDto productDto = feignClientService.getProductById(id);
		
		return new ResponseEntity<>(productDto, HttpStatus.OK);
	}
	

}
