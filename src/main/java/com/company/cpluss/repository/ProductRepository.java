package com.company.cpluss.repository;

import com.company.cpluss.model.items.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
