package com.example.OrderManagementSystem.services;

import com.example.OrderManagementSystem.domain.dto.CustomerDto;
import com.example.OrderManagementSystem.domain.model.Customer;
import com.example.OrderManagementSystem.repositories.CustomerRepository;
import com.example.OrderManagementSystem.util.CustomerMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerDto saveCustomer(CustomerDto customerDto) {
        log.info(customerDto.toString());
        Customer customer = CustomerMapper.INSTANCE.toEntity(customerDto);
        customer.setRegistrationCode( UUID.randomUUID().toString());
        log.info(customer.toString());
        return CustomerMapper.INSTANCE.toDto(customerRepository.save(customer));
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).get();
    }
}
