package com.rest.template.main.service;

import com.rest.template.main.model.ProductDto;

public interface ProductClientService {

	ProductDto createProduct(ProductDto productDto);

	void updateProduct(String id, ProductDto productDto);

	void deleteProduct(String id);

	ProductDto getProductById(String id);

}
