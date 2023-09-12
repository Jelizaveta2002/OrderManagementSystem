package com.example.OrderManagementSystem.services;

import com.example.OrderManagementSystem.domain.dto.CustomerDto;
import com.example.OrderManagementSystem.domain.dto.OrderDto;
import com.example.OrderManagementSystem.domain.model.Customer;
import com.example.OrderManagementSystem.domain.model.Order;
import com.example.OrderManagementSystem.repositories.OrderRepository;
import com.example.OrderManagementSystem.util.CustomerMapper;
import com.example.OrderManagementSystem.util.OrderMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderDto saveOrder(OrderDto orderDto) {
        log.info(orderDto.toString());
        Order order = OrderMapper.INSTANCE.toEntity(orderDto);
        order.setDateSubmitted(LocalDateTime.now());
        log.info(order.toString());
        return OrderMapper.INSTANCE.toDto(orderRepository.save(order));
    }
}
