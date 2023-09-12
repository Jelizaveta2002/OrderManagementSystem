package com.example.OrderManagementSystem.repositories;

import com.example.OrderManagementSystem.domain.model.Order;
import com.example.OrderManagementSystem.domain.model.OrderLine;
import com.example.OrderManagementSystem.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {
    @Query("SELECT o FROM OrderLine o WHERE o.product = :product")
    List<OrderLine> getOrderLineByProduct(@Param("product") Product product);
}
