package com.kocirfan.product.repository.mongo;

import com.kocirfan.product.domain.category.Category;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CategoryRepository extends ReactiveMongoRepository<Category, String> {
}
