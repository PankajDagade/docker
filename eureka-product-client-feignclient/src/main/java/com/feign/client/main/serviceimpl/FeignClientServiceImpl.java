package com.feign.client.main.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.feign.client.main.client.FeignClientConsumer;
import com.feign.client.main.model.ProductDto;
import com.feign.client.main.service.FeignClientService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;






@Service
public class FeignClientServiceImpl implements FeignClientService {
	
	@Autowired private FeignClientConsumer feignClient;

	@Override
	public ProductDto createProduct(ProductDto productDto) {
		ResponseEntity<ProductDto> responseDto = feignClient.createProduct(productDto);
		return responseDto.getBody();
	}

	@Override
	public void updateProduct(String id, ProductDto productDto) {
		feignClient.updateProduct(id, productDto);
	}

	@Override
	public void deleteProduct(String id) {
		feignClient.deleteProduct(id);
		
	}

	@Override
	@CircuitBreaker(name = "productService", fallbackMethod = "fallbackGetProduct")
	public ProductDto getProductById(String id) {
		
		ResponseEntity<ProductDto> pdto = feignClient.getProductById(id);
		return pdto.getBody();
	}
	
	public ProductDto fallbackGetProduct(String id,Exception ex)
	{
	    System.out.println("Fallback triggered due to: " + ex.getMessage());
	    
	    ProductDto product = new ProductDto();
	    product.setName("None");
	    product.setEmail("None Email");
	    
		return product;
	}

}
