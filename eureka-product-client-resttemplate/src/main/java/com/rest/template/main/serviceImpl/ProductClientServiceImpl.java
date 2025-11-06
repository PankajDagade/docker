package com.rest.template.main.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rest.template.main.model.ProductDto;
import com.rest.template.main.service.ProductClientService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@Service
public class ProductClientServiceImpl implements ProductClientService {
	
	
	int count=0;
	
	
	@Autowired private RestTemplate restTemplate;
	
	//http://localhost:8081/products/product/645e2424-7181-4e3d-9a00-1bbb442511d7
	private final static String BASE_URL = "http://PRODUCT-SERVICE/products/product";
	
	//private final static String BASE_URL = "http://localhost:8081/products/product";


	@Override
	public ProductDto createProduct(ProductDto productDto) {
		
		ResponseEntity<ProductDto> responseProductDto = restTemplate.postForEntity(BASE_URL, productDto, ProductDto.class);
		
		return responseProductDto.getBody();
	}

	@Override
	public void updateProduct(String id, ProductDto productDto) {
		
		String url = BASE_URL.concat(id);
		
	    restTemplate.put(url, productDto);
	
	}

	@Override
	public void deleteProduct(String id) {
		
		String url = BASE_URL + "/" + id;
		
		restTemplate.delete(url);
		
	}
 
	@Override
	@CircuitBreaker(name = "PRODUCT-SERVICE", fallbackMethod = "fallBackMethodOfProduct")
	//@Retry(name = "PRODUCT-SERVICE", fallbackMethod = "fallBackMethodOfProduct")
	public ProductDto getProductById(String id) {
		//http://localhost:8081/products/product/645e2424-7181-4e3d-9a00-1bbb442511d7
		count++;
		String url = BASE_URL + "/" + id;
		ResponseEntity<ProductDto> response = restTemplate.getForEntity(url, ProductDto.class);
		return response.getBody();
	}
	
	public ProductDto fallBackMethodOfProduct(String id, Throwable throwable) {
		
		System.out.println("Failed Method "+throwable.getMessage());
		
		ProductDto p = new ProductDto();
		p.setName("ABC");
		p.setEmail("ABC@gmailcom");
		
		return p;
	}
	
	

}
