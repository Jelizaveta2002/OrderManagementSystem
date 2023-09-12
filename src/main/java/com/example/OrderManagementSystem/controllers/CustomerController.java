package com.example.OrderManagementSystem.controllers;

import com.example.OrderManagementSystem.domain.dto.CustomerDto;
import com.example.OrderManagementSystem.domain.dto.OrderDto;
import com.example.OrderManagementSystem.domain.dto.OrderLineDto;
import com.example.OrderManagementSystem.services.CustomerService;
import com.example.OrderManagementSystem.services.OrderLineService;
import com.example.OrderManagementSystem.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private final CustomerService customerService;

    private final OrderLineService orderLineService;

    private final OrderService orderService;

    @PostMapping(value = "addCustomer")
    public CustomerDto addCustomer(@RequestBody CustomerDto customerDto) {
        return customerService.saveCustomer(customerDto);
    }

    @PostMapping(value = "addOrderLine")
    public OrderLineDto addOrderLine(@RequestBody OrderLineDto orderLineDto) {
        return orderLineService.saveOrderLine(orderLineDto);
    }

    @PostMapping(value = "addOrder")
    public OrderDto addOrder(@RequestBody OrderDto orderDto) {
        return orderService.saveOrder(orderDto);
    }
}
