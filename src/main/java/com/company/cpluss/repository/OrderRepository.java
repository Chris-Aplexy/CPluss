package com.company.cpluss.repository;

import com.company.cpluss.model.items.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
