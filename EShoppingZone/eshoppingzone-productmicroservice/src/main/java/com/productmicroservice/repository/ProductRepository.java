package com.productmicroservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.productmicroservice.entity.Product;


public interface ProductRepository extends MongoRepository<Product, Integer>{
	
}
