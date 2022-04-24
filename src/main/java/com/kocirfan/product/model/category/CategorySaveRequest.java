package com.kocirfan.product.model.category;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategorySaveRequest {
    String name;
}
