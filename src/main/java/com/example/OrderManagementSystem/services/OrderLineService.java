package com.example.OrderManagementSystem.services;

import com.example.OrderManagementSystem.domain.dto.OrderDto;
import com.example.OrderManagementSystem.domain.dto.OrderLineDto;
import com.example.OrderManagementSystem.domain.model.OrderLine;
import com.example.OrderManagementSystem.repositories.OrderLineRepository;
import com.example.OrderManagementSystem.util.OrderLineMapper;
import com.example.OrderManagementSystem.util.OrderMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class OrderLineService {

    private final OrderLineRepository orderLineRepository;

    public OrderLineDto saveOrderLine(OrderLineDto orderLineDto) {
        log.info(orderLineDto.toString());
        OrderLine orderLine = OrderLineMapper.INSTANCE.toEntity(orderLineDto);
        log.info(orderLine.toString());
        return OrderLineMapper.INSTANCE.toDto(orderLineRepository.save(orderLine));
    }

    public Optional<OrderLineDto> getOrderLineById(Long id) {
        return Optional.ofNullable(OrderLineMapper.INSTANCE.toDto(orderLineRepository.findById(id).get()));
    }
}
