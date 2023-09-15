package com.example.OrderManagementSystem.domain.dto;

import com.example.OrderManagementSystem.domain.model.Customer;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder(access = AccessLevel.PUBLIC)
public class OrderDto {

    private Long id;

    @NotNull
    private Long customerId;

    private LocalDateTime dateSubmitted;

    private List<OrderLineDto> orderLines;
}
