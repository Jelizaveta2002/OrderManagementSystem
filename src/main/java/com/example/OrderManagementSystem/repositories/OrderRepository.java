package com.example.OrderManagementSystem.repositories;

import com.example.OrderManagementSystem.domain.model.Customer;
import com.example.OrderManagementSystem.domain.model.Order;
import com.example.OrderManagementSystem.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findAllByCustomer(Customer customer);

    List<Order> findAllByDateSubmitted(LocalDateTime localDateTime);

    @Query("SELECT o FROM Order o WHERE o.customer = :customer")
    List<Order> getOrdersByCustomer(@Param("customer") Customer customer);

    @Query("SELECT DISTINCT o FROM Order o WHERE o.id IN " +
            "(SELECT DISTINCT ol.order.id FROM OrderLine ol WHERE ol.product = :product)")
    List<Order> findOrdersByProduct(Product product);
}
