package com.example.OrderManagementSystem.util;

import com.example.OrderManagementSystem.domain.dto.ProductDto;
import com.example.OrderManagementSystem.domain.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product toEntity(ProductDto productDto);

    ProductDto toDto(Product product);
}