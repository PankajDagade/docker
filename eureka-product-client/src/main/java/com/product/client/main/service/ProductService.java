package com.product.client.main.service;

import com.product.client.main.dto.ProductDto;

public interface ProductService {

	
	ProductDto createProduct(ProductDto productDto);
	
	ProductDto updateProduct(String id, ProductDto productDto);
	
	ProductDto deleteProduct(String id);
	
	ProductDto getProductById(String id);
}


