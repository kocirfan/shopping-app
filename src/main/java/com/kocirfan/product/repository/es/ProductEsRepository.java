package com.kocirfan.product.repository.es;

import com.kocirfan.product.domain.es.ProductEs;
import org.springframework.data.elasticsearch.repository.ReactiveElasticsearchRepository;

public interface ProductEsRepository extends ReactiveElasticsearchRepository<ProductEs, String> {


}
