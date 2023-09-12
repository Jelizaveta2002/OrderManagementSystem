package com.example.OrderManagementSystem.util;

import com.example.OrderManagementSystem.domain.dto.OrderLineDto;
import com.example.OrderManagementSystem.domain.model.OrderLine;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderLineMapper {
    OrderLineMapper INSTANCE = Mappers.getMapper(OrderLineMapper.class);

    @Mapping(source = "orderId", target = "order.id")
    @Mapping(source = "productId", target = "product.id")
    OrderLine toEntity(OrderLineDto orderLineDto);

    @Mapping(source = "order.id", target = "orderId")
    @Mapping(source = "product.id", target = "productId")
    OrderLineDto toDto(OrderLine orderLine);
}