package com.product.client.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
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

import com.product.client.main.dto.ProductDto;
import com.product.client.main.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	
	@Autowired private ProductService productService;
	
	//http://localhost:8081/products/product
	@PostMapping("/product")
	public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto)
	{
		ProductDto savedProductDto = productService.createProduct(productDto);
		
		return new ResponseEntity<>(savedProductDto, HttpStatus.CREATED);
	}
	
	@PutMapping("/product/{id}")
	public ResponseEntity<ProductDto> updateProduct(@PathVariable String id, @RequestBody ProductDto productDto)
	{
		ProductDto updatedProduct = productService.updateProduct(id, productDto);
		return new ResponseEntity<>(updatedProduct, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/product/{id}")
	public ResponseEntity<ProductDto> deleteProduct(@PathVariable String id)
	{
		ProductDto deletedProduct = productService.deleteProduct(id);
		
		return new ResponseEntity<>(deletedProduct, HttpStatus.OK);
	}
	
	@GetMapping("/product/{id}")
	public ResponseEntity<ProductDto> getProductById(@PathVariable String id)
	{
		ProductDto productDto = productService.getProductById(id);
		
		return new ResponseEntity<>(productDto, HttpStatus.OK);
	}

}
