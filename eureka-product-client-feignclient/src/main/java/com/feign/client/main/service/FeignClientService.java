package com.feign.client.main.service;

import com.feign.client.main.model.ProductDto;

public interface FeignClientService {

	ProductDto createProduct(ProductDto productDto);

	

	void updateProduct(String id, ProductDto productDto);



	void deleteProduct(String id);



	ProductDto getProductById(String id);

}
