package com.kocirfan.product.service;

import com.kocirfan.product.domain.Product;
import com.kocirfan.product.domain.es.CategoryEs;
import com.kocirfan.product.domain.es.CompanyEs;
import com.kocirfan.product.domain.es.ProductEs;
import com.kocirfan.product.repository.es.ProductEsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
@RequiredArgsConstructor
public class ProductEsService {

    private final ProductEsRepository productEsRepository;



    public Mono<ProductEs> saveNewProduct(Product product){
      return productEsRepository.save(
        ProductEs.builder()
                .active(product.getActive())
                .code(product.getCode())
                .description(product.getDescription())
                .features(product.getFeatures())
                .id(product.getId())
                .name(product.getName())
                // TODO get company name and code
                .seller(CompanyEs.builder().id(product.getCompanyId()).name("Test Company").build())
                // TODO get category name and code
                .category(CategoryEs.builder().id(product.getCategoryId()).name("Test Category").build())
                .build());

    }

    public Flux<ProductEs> findAll() {
       return productEsRepository.findAll();
    }
}
