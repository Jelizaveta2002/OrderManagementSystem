package com.example.OrderManagementSystem.controllers;

import com.example.OrderManagementSystem.domain.dto.CustomerDto;
import com.example.OrderManagementSystem.domain.dto.OrderDto;
import com.example.OrderManagementSystem.domain.dto.OrderLineDto;
import com.example.OrderManagementSystem.domain.dto.ProductDto;
import com.example.OrderManagementSystem.services.CustomerService;
import com.example.OrderManagementSystem.services.OrderLineService;
import com.example.OrderManagementSystem.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

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

    @GetMapping(value = "getOrdersByCustomer")
    public List<OrderDto> getOrdersByCustomer(@RequestBody CustomerDto customerDto) {
        return orderService.getOrdersByCustomer(customerDto);
    }

    @GetMapping(value = "getOrderById")
    public OrderDto getOrderById(Long id) {
        return orderService.getOrderById(id);
    }

    @GetMapping(value = "getOrderLineById")
    public Optional<OrderLineDto> getOrderLineById(Long id) {
        return orderLineService.getOrderLineById(id);
    }

    @GetMapping(value = "getOrdersByDate")
    public List<OrderDto> getOrdersById(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date) {
        return orderService.getOrdersByDate(date);
    }

    @GetMapping(value = "getOrdersByProduct")
    public List<OrderDto> getOrdersByProduct(@RequestBody ProductDto productDto) {
        return orderService.getOrdersByProduct(productDto);
    }

    @PutMapping(value = "updateOrderLine")
    public void updateOrderLine(@RequestBody OrderLineDto orderLineDto) {
        orderLineService.updateOrderLineProduct(orderLineDto);
    }
}
