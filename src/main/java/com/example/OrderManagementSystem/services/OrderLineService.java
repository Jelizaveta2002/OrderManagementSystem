package com.example.OrderManagementSystem.services;

import com.example.OrderManagementSystem.domain.dto.OrderLineDto;
import com.example.OrderManagementSystem.domain.model.OrderLine;
import com.example.OrderManagementSystem.repositories.OrderLineRepository;
import com.example.OrderManagementSystem.util.OrderLineMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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

    @Transactional
    public void updateOrderLineProduct(OrderLineDto updatedOrderLineDto) {
        Optional<OrderLine> optOrderLine = orderLineRepository.findById(updatedOrderLineDto.getId());
        if (optOrderLine.isPresent()) {
            OrderLine orderLine = optOrderLine.get();
            OrderLineMapper.INSTANCE.updateEntityFromDTO(updatedOrderLineDto, orderLine);
        }
    }
}
