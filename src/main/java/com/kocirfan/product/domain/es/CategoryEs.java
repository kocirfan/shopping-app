package com.kocirfan.product.domain.es;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
public class CategoryEs {

    private String id;
    private String name;
    private String code;
}
