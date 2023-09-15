package com.example.OrderManagementSystem.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
