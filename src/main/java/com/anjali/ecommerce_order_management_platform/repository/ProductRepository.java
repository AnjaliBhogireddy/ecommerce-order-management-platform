package com.anjali.ecommerce_order_management_platform.repository;

import com.anjali.ecommerce_order_management_platform.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
