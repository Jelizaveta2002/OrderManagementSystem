package com.example.OrderManagementSystem.domain.dto;

import com.example.OrderManagementSystem.domain.model.Order;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.ArrayList;
import java.util.List;

@Data
public class CustomerDto {

    private Long id;

    @NotNull
    private String registrationCode;

    @NotNull
    private String fullName;

    @NotNull
    private String email;

    @NotNull
    private String telephone;

    protected List<Order> customerOrders = new ArrayList<>();
}
