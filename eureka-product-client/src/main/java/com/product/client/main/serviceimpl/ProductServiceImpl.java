package com.product.client.main.serviceimpl;


import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.product.client.main.dto.ProductDto;
import com.product.client.main.model.Product;
import com.product.client.main.repository.ProductRepository;
import com.product.client.main.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	
	@Autowired private ProductRepository productRepository;
	
	@Autowired private ModelMapper modelMapper;

	@Override
	@CachePut(
			value = "USERS_DATA",
			key = "#result.id"
			)
	public ProductDto createProduct(ProductDto productDto) {
		Product product = modelMapper.map(productDto, Product.class);
		
		product.setId(UUID.randomUUID().toString());
		
		Product savedProduct = productRepository.save(product);
		
		return modelMapper.map(savedProduct, ProductDto.class);
	}

	@Override
	@CachePut(
			value = "USERS_DATA",
			key = "#id"
			)
	public ProductDto updateProduct(String id, ProductDto productDto) {
		Product existingProduct = productRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Id not found"));
		existingProduct.setName(productDto.getName());
		existingProduct.setEmail(productDto.getEmail());
		
		Product updatedProduct = productRepository.save(existingProduct);
		
		return modelMapper.map(updatedProduct, ProductDto.class);
	}

	@Override
	@CacheEvict(
			value = "USERS_DATA",
			key = "#id"
			)
	public ProductDto deleteProduct(String id) {
		
		Product existingProduct = productRepository.findById(id)
				.orElse(null);
		
		productRepository.delete(existingProduct);
		
		return modelMapper.map(existingProduct, ProductDto.class);
	}

	@Override
	@Cacheable(
			value = "USERS_DATA",
			key = "#id"
			)
	public ProductDto getProductById(String id) {
		
		Product exisitingProduct = productRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Product Id not Found"));
		
		return modelMapper.map(exisitingProduct, ProductDto.class);
	}

}
