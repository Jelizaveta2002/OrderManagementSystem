package com.example.OrderManagementSystem.domain.dto;

import lombok.Builder;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

@Data
@Builder
public class OrderLineDto {

    private Long id;

    @NotNull
    private Long orderId;

    @NotNull
    private Long productId;

    @NotNull
    private Integer quantity;
}

