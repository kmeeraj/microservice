package com.teradata.traning.inventoryservice.repository;

import com.teradata.traning.inventoryservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
