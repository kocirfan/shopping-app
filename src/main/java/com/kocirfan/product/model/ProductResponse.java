package com.kocirfan.product.model;

import com.kocirfan.product.domain.MoneyTypes;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Data
@Getter
@Setter
@Builder
public class ProductResponse {
    // DTO alanı

    private String id;
    private String image;
    private String name;
    private String description;
    private ProductSellerResponse seller;
    private String features;
    private int available;
    private String deliveryIn;
    private BigDecimal price;
    private String categoryId;
    private Boolean freeDelivery;
    private MoneyTypes moneyType;
}
