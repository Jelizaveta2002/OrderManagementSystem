package com.example.OrderManagementSystem.repositories;

import com.example.OrderManagementSystem.domain.model.Customer;
import com.example.OrderManagementSystem.domain.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findAllByCustomer(Customer customer);

    List<Order> findAllByDateSubmitted(LocalDateTime localDateTime);
}
