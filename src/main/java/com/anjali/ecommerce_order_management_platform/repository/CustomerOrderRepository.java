package com.anjali.ecommerce_order_management_platform.repository;

import com.anjali.ecommerce_order_management_platform.entity.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Long> {

    List<CustomerOrder> findByCustomerCustomerId(Long customerId);

}