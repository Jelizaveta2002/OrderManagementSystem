package com.example.OrderManagementSystem.services;

import com.example.OrderManagementSystem.domain.dto.OrderLineDto;
import com.example.OrderManagementSystem.domain.model.OrderLine;
import com.example.OrderManagementSystem.repositories.OrderLineRepository;
import com.example.OrderManagementSystem.util.OrderLineMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
}
