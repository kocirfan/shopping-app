package com.kocirfan.product.model;

import com.kocirfan.product.domain.MoneyTypes;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;


@Data
@Builder
public class ProductSaveRequest {
    private String id;
    private String name;
    private String description;
    private String features;
    private BigDecimal available;
    private BigDecimal price;
    private MoneyTypes money;
    private List<String> images;
    private String sellerId;
    private String categoryId;
}
