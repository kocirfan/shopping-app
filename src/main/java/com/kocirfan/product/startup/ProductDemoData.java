package com.kocirfan.product.startup;

import com.kocirfan.product.domain.MoneyTypes;
import com.kocirfan.product.model.ProductSaveRequest;
import com.kocirfan.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.UUID.randomUUID;

@Component
@RequiredArgsConstructor
public class ProductDemoData {
    private final ProductService productService;

    @EventListener(ApplicationReadyEvent.class)
    public void migrate(){
        Long countOfData = productService.count().block();
        if(countOfData.equals(0L)){
            IntStream.range(0, 10).forEach(item ->{
                productService.save(
                     ProductSaveRequest.builder()
                        .sellerId(randomUUID().toString())
                        .id(randomUUID().toString())
                        .description("Product Description" + item)
                        .money(MoneyTypes.USD)
                        .categoryId(randomUUID().toString())
                        .name("Product Name " + item)
                        .features("<li> Black Color</li> <li>Aliminum Case</li> <li>2 Years Warrantly</li> <li>Inch (35 * 55)</li>")
                        .price(BigDecimal.TEN)
                        .images(List.of("https://productimages.hepsiburada.net/s/32/500/10352568139826.jpg"))
                        .build());

            });
        }
    }
}
