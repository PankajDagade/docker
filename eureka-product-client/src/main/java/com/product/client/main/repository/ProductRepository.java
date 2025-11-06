package com.product.client.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.client.main.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

}
