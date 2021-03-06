package com.kocirfan.product.domain.es;

import com.kocirfan.product.domain.MoneyTypes;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;

import java.math.BigDecimal;
import java.util.HashMap;

@Document(indexName = "product")
@Getter
@Setter
@Builder
@EqualsAndHashCode(of = "id")
public class ProductEs {
//elasticsearch sorgulamalar─▒


    private String id;
    private String name;
    private String code;
    private String description;
    private CompanyEs seller;
    private String features;
    private CategoryEs category;
    private HashMap<MoneyTypes, BigDecimal> price;
    private Boolean active;
}
