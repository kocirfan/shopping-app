package com.kocirfan.product.startup;

import com.kocirfan.product.domain.MoneyTypes;
import com.kocirfan.product.model.category.CategoryResponse;
import com.kocirfan.product.model.category.CategorySaveRequest;
import com.kocirfan.product.model.product.ProductSaveRequest;
import com.kocirfan.product.repository.es.ProductEsRepository;
import com.kocirfan.product.service.ProductService;
import com.kocirfan.product.service.category.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.UUID.randomUUID;

@Component
@RequiredArgsConstructor
public class ProductDemoData {
    private final ProductService productService;
    private final ProductEsRepository productEsRepository;
    private final CategoryService categoryService;

    @EventListener(ApplicationReadyEvent.class)
    public void migrate() {
        Long countOfData = productService.count().block();
        if (countOfData.equals(0L)) {

            productEsRepository.deleteAll().block();

            CategoryResponse bilgisayar = categoryService.save(CategorySaveRequest.builder().name("Bilgisayar").build());
            CategoryResponse telefon = categoryService.save(CategorySaveRequest.builder().name("Telefon").build());


            IntStream.range(0, 10).forEach(item -> {
                HashMap<MoneyTypes, BigDecimal> price = new HashMap<>() {{
                    put(MoneyTypes.USD, BigDecimal.valueOf((item + 1) * 5));
                    put(MoneyTypes.EUR, BigDecimal.valueOf((item + 1) * 4));
                }};
                productService.save(
                        ProductSaveRequest.builder()
                                .sellerId(randomUUID().toString())
                                .id(randomUUID().toString())
                                .description("Product Description" + item)
                                .price(price)
                                .categoryId(telefon.getId())
                                .name("Product Name " + item)
                                .features("<li> Black Color</li> <li>Aliminum Case</li> <li>2 Years Warrantly</li> <li>Inch (35 * 55)</li>")
                                .images(List.of("https://productimages.hepsiburada.net/s/32/500/10352568139826.jpg"))
                                .build());

            });
        }
    }
}
