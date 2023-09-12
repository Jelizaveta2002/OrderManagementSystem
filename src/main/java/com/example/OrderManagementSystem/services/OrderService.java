package com.example.OrderManagementSystem.services;

import com.example.OrderManagementSystem.domain.dto.CustomerDto;
import com.example.OrderManagementSystem.domain.dto.OrderDto;
import com.example.OrderManagementSystem.domain.model.Customer;
import com.example.OrderManagementSystem.domain.model.Order;
import com.example.OrderManagementSystem.repositories.OrderRepository;
import com.example.OrderManagementSystem.util.CustomerMapper;
import com.example.OrderManagementSystem.util.OrderLineMapper;
import com.example.OrderManagementSystem.util.OrderMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<OrderDto> getOrdersByCustomer(CustomerDto customerDto) {
        Customer customer = CustomerMapper.INSTANCE.toEntity(customerDto);
        return orderRepository.findAllByCustomer(customer)
                .stream()
                .map(order -> {
                    OrderDto orderDto = OrderMapper.INSTANCE.toDto(order);
                    orderDto.setOrderLines(
                            order.getOrderLines()
                                    .stream()
                                    .map(OrderLineMapper.INSTANCE::toDto)
                                    .collect(Collectors.toList())
                    );
                    return orderDto;
                })
                .collect(Collectors.toList());
    }

    public OrderDto getOrderById(Long id) {
        Optional<Order> orderOpt = orderRepository.findById(id);
        Order order = orderOpt.get();
        OrderDto orderDto = OrderMapper.INSTANCE.toDto(order);
        orderDto.setOrderLines(order.getOrderLines().stream().map(OrderLineMapper.INSTANCE :: toDto).toList());
        return orderDto;
    }

    public List<OrderDto> getOrdersByDate(LocalDateTime dateSubmitted) {
        return orderRepository.findAllByDateSubmitted(dateSubmitted).
                stream().map(OrderMapper.INSTANCE::toDto).toList();
    }
}
