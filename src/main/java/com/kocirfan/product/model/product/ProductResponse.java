package com.kocirfan.product.model.product;

import com.kocirfan.product.domain.MoneyTypes;
import com.kocirfan.product.model.ProductSellerResponse;
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
    private boolean freeDelivery;
    private String deliveryIn;
    private BigDecimal price;
    private String moneySymbol;
    private String categoryId;

}
