package com.kocirfan.product.service;

import com.kocirfan.product.domain.MoneyTypes;
import com.kocirfan.product.domain.Product;
import com.kocirfan.product.domain.ProductImage;
import com.kocirfan.product.domain.es.ProductEs;
import com.kocirfan.product.model.ProductResponse;
import com.kocirfan.product.model.ProductSaveRequest;
import com.kocirfan.product.model.ProductSellerResponse;
import com.kocirfan.product.repository.es.ProductEsRepository;
import com.kocirfan.product.repository.mongo.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    // sorguları es ten yapıyor CRUD ları mongo da



    private final ProductRepository productRepository;
    private final ProductPriceService productPriceService;
    private final ProductDeliveryService productDeliveryService;
    private final ProductAmountService productAmountService;
    private final ProductImageService productImageService;
    private final ProductEsService productEsService;
    // dışarıya dto ları açıyoruz

    public Flux<ProductResponse> getAll(){
       return productEsService.findAll().map(this::mapToDto);

        // 1- ES den sorgula
    }

    // 1- Mongoya yaz
    // 2- es güncelle
    // 3- redis güncelle
    // 4- es den cevap dön
    // 5- response nesnesine dönüştür


    public ProductResponse save(ProductSaveRequest request){
       Product product = Product.builder()
                .active(Boolean.TRUE)
                .code("PR0001")
                .categoryId(request.getCategoryId())
                .companyId(request.getSellerId())
                .description(request.getDescription())
                .features(request.getFeatures())
                .name(request.getName())
                .productImage(request.getImages().stream().map(it -> new ProductImage(ProductImage.ImageType.FEATURE, it)).collect(Collectors.toList()))
                .build();
        product = productRepository.save(product).block();




        return this.mapToDto(productEsService.saveNewProduct(product).block());
    }


    // 2- Calculate fieldları işle
    // 3- redisten ihtiyaç alanlarını getir
    // 4- response nesnesine dönüştür
    private ProductResponse mapToDto(ProductEs item) {
        if(item == null){
            return null;
        }
        BigDecimal productPrice = productPriceService.getByMoneyType(item.getId(), MoneyTypes.USD);
         return ProductResponse.builder()
                 .price(productPrice)
                 .name(item.getName())
                 .features(item.getFeatures())
                 .id(item.getId())
                 .description(item.getDescription())
                 .deliveryIn(productDeliveryService.getDeliveryInfo(item.getId()))
                 .categoryId(item.getCategory().getId())
                 .available(productAmountService.getByProductId(item.getId()))
                 .freeDelivery(productDeliveryService.freeDeliveryCheck(item.getId(), productPrice))
                 .moneyType(MoneyTypes.USD)
                 .image(productImageService.getProductMainImage(item.getId()))
                 .seller(ProductSellerResponse.builder().id(item.getSeller().getId()).name(item.getSeller().getName()).build())
                 .build();

    }

    public Mono<Long> count() {
        return productRepository.count();
    }

}
