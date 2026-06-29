package com.anjali.ecommerce_order_management_platform.repository;

import com.anjali.ecommerce_order_management_platform.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}