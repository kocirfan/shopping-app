package com.kocirfan.product.repository.mongo;

import com.kocirfan.product.domain.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductRepository extends ReactiveMongoRepository<Product, String> {

}
