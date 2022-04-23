package com.kocirfan.product.service;

import com.kocirfan.product.domain.MoneyTypes;
import com.kocirfan.product.repository.mongo.ProductPriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class ProductPriceService {

    private final ProductPriceRepository productPriceRepository;

    public BigDecimal getByMoneyType(String id, MoneyTypes usd){
        return BigDecimal.TEN;
    }
}
