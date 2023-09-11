package com.example.OrderManagementSystem.services;

import com.example.OrderManagementSystem.domain.dto.ProductDto;
import com.example.OrderManagementSystem.domain.model.Product;
import com.example.OrderManagementSystem.repositories.ProductRepository;
import com.example.OrderManagementSystem.util.ProductMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public ProductDto saveProduct(ProductDto productDto) {
        log.info(productDto.toString());
        Product product = ProductMapper.INSTANCE.toEntity(productDto);
        String skuCode = product.getName().substring(0, Math.min(product.getName().length(), 2));
        skuCode = skuCode + generateRandomDigits(8);
        product.setSkuCode(skuCode);
        log.info(product.toString());
        return ProductMapper.INSTANCE.toDto(productRepository.save(product));
    }

    private String generateRandomDigits(int length) {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            stringBuilder.append(random.nextInt(10));
        }
        return stringBuilder.toString();
    }
}
