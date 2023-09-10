package com.example.OrderManagementSystem.domain.dto;

import com.example.OrderManagementSystem.domain.model.Customer;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDateTime;

@Data
public class OrderDto {

    private Long id;

    @NotNull
    private Customer customer;

    @NotNull
    private LocalDateTime dateSubmitted;
}
