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
    @Mapping(source = "orderLines", target = "orderLines")
    Order toEntity(OrderDto orderDto);

    @Mapping(source = "customer.id", target = "customerId")
    @Mapping(source = "orderLines", target = "orderLines")
    OrderDto toDto(Order order);
}
