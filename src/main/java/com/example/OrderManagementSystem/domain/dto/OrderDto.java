package com.example.OrderManagementSystem.domain.dto;

import com.example.OrderManagementSystem.domain.model.Customer;
import lombok.Builder;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDateTime;

@Data
@Builder
public class OrderDto {

    private Long id;

    @NotNull
    private Long customerId;

    private LocalDateTime dateSubmitted;
}
