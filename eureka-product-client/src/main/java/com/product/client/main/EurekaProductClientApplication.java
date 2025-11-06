package com.product.client.main;


import org.modelmapper.ModelMapper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class EurekaProductClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaProductClientApplication.class, args);
	}
	
	@Bean
	public ModelMapper mapper()
	{
		return new ModelMapper();
	}

}
