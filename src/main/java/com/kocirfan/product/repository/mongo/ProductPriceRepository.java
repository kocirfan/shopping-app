package com.kocirfan.product.repository.mongo;

import com.kocirfan.product.domain.ProductPrice;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductPriceRepository extends ReactiveMongoRepository<ProductPrice, String> {

}
