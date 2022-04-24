package com.kocirfan.product.service;

import com.kocirfan.product.domain.MoneyTypes;
import com.kocirfan.product.domain.Product;
import com.kocirfan.product.domain.category.Category;
import com.kocirfan.product.domain.es.CategoryEs;
import com.kocirfan.product.domain.es.CompanyEs;
import com.kocirfan.product.domain.es.ProductEs;
import com.kocirfan.product.repository.es.ProductEsRepository;
import com.kocirfan.product.service.category.CategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.internal.bytebuddy.description.annotation.AnnotationDescription;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
@RequiredArgsConstructor
public class ProductEsService {

    private final ProductEsRepository productEsRepository;
    private final CategoryService categoryService;


    public Mono<ProductEs> saveNewProduct(Product product) {
        return productEsRepository.save(
                ProductEs.builder()
                        .active(product.getActive())
                        .code(product.getCode())
                        .description(product.getDescription())
                        .features(product.getFeatures())
                        .id(product.getId())
                        .price(product.getPrice())
                        .name(product.getName())
                        // TODO get company name and code
                        .seller(CompanyEs.builder().id(product.getCompanyId()).name("Test Company").build())
                        .category(getProductCategory(product.getCategoryId()))
                        .build());

    }

    private CategoryEs getProductCategory(String categoryId) {
        Category category = categoryService.getById(categoryId);
        return CategoryEs.builder()
                .name(category.getName())
                .id(category.getId())
                .code(category.getCode())
                .build();
    }

    public Flux<ProductEs> findAll() {
        return productEsRepository.findAll();
    }
}
