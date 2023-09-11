package com.example.OrderManagementSystem.domain.dto;

import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

@Data
public class ProductDto {

    private Long id;

    @NotNull
    private String name;

    private String skuCode;

    @NotNull
    private Double unitPrice;
}
