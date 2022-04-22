package com.kocirfan.product.service;

import com.kocirfan.product.model.ProductResponse;
import com.kocirfan.product.model.ProductSaveRequest;
import com.kocirfan.product.repository.es.ProductEsRepository;
import com.kocirfan.product.repository.mongo.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    // sorguları es ten yapıyor CRUD ları mongo da

    private final ProductEsRepository productEsRepository;
    private final ProductRepository productRepository;

    // dışarıya dto ları açıyoruz

    List<ProductResponse> getByPaging(Pageable pageable){
        // 1- ES den sorgula
        // 2- Calculate fieldları işle
        // 3- redisten ihtiyaç alanlarını getir
        // 4- response nesnesine dönüştür
        return  null;
    }

    ProductResponse save(ProductSaveRequest productSaveRequest){
        // 1- Mongoya yaz
        // 2- es güncelle
        // 3- redis güncelle
        // 4- es den cevap dön
        // 5- response nesnesine dönüştür
        return null;
    }
}
