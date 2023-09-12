package com.example.OrderManagementSystem.util;

import com.example.OrderManagementSystem.domain.dto.OrderDto;
import com.example.OrderManagementSystem.domain.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    @Mapping(source = "customerId", target = "customer.id")
    Order toEntity(OrderDto orderDto);

    @Mapping(source = "customer.id", target = "customerId")
    OrderDto toDto(Order order);
}
