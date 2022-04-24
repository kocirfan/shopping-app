package com.kocirfan.product.service;

import com.kocirfan.product.domain.MoneyTypes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class ProductDeliveryService {

    public String getDeliveryInfo(String productId) {
        // TODO
        return "Tomorrow";
    }

    public boolean freeDeliveryCheck(String productId, BigDecimal price, MoneyTypes moneyTypes) {
        // TODO
        return true;
    }
}
