package com.example.OrderManagementSystem.util;

import com.example.OrderManagementSystem.domain.dto.CustomerDto;
import com.example.OrderManagementSystem.domain.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    Customer toEntity(CustomerDto customerDto); // Corrected source type

    CustomerDto toDto(Customer customer); // Corrected target type
}
