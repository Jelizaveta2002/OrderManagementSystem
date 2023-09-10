package com.example.OrderManagementSystem.domain.dto;

import com.example.OrderManagementSystem.domain.model.Order;
import com.example.OrderManagementSystem.domain.model.Product;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

@Data
public class OrderLineDto {

    private Long id;

    @NotNull
    private Order order;

    @NotNull
    private Product product;

    @NotNull
    private Integer quantity;
}
