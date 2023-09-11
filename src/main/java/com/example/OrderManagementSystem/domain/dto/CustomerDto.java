package com.example.OrderManagementSystem.domain.dto;

import lombok.Builder;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class CustomerDto {

    private Long id;

    private String registrationCode;

    @NotNull
    private String fullName;

    @NotNull
    private String email;

    @NotNull
    private String telephone;

    protected List<OrderDto> customerOrders = new ArrayList<>();
}
