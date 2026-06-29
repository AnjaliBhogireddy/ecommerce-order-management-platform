package com.anjali.ecommerce_order_management_platform.service;

import com.anjali.ecommerce_order_management_platform.dto.OrderItemRequestDto;
import com.anjali.ecommerce_order_management_platform.dto.OrderRequestDto;
import com.anjali.ecommerce_order_management_platform.entity.Customer;
import com.anjali.ecommerce_order_management_platform.entity.CustomerOrder;
import com.anjali.ecommerce_order_management_platform.entity.OrderItem;
import com.anjali.ecommerce_order_management_platform.entity.Product;
import com.anjali.ecommerce_order_management_platform.repository.CustomerOrderRepository;
import com.anjali.ecommerce_order_management_platform.repository.CustomerRepository;
import com.anjali.ecommerce_order_management_platform.repository.OrderItemRepository;
import com.anjali.ecommerce_order_management_platform.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class OrderService {

    private final CustomerOrderRepository customerOrderRepository;
    private final OrderItemRepository orderItemRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    public OrderService(CustomerOrderRepository customerOrderRepository,
                        OrderItemRepository orderItemRepository,
                        CustomerRepository customerRepository,
                        ProductRepository productRepository) {
        this.customerOrderRepository = customerOrderRepository;
        this.orderItemRepository = orderItemRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    public CustomerOrder placeOrder(OrderRequestDto requestDto) {

        Customer customer = customerRepository.findById(requestDto.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + requestDto.getCustomerId()));

        CustomerOrder order = new CustomerOrder();
        order.setCustomer(customer);
        order.setOrderStatus("PLACED");
        order.setOrderDate(LocalDateTime.now());
        order.setTotalAmount(BigDecimal.ZERO);

        CustomerOrder savedOrder = customerOrderRepository.save(order);

        BigDecimal totalAmount = BigDecimal.ZERO;

        for (OrderItemRequestDto itemDto : requestDto.getItems()) {

            Product product = productRepository.findById(itemDto.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found with id: " + itemDto.getProductId()));

            if (product.getStockQuantity() < itemDto.getQuantity()) {
                throw new RuntimeException("Insufficient stock for product: " + product.getProductName());
            }

            product.setStockQuantity(product.getStockQuantity() - itemDto.getQuantity());
            productRepository.save(product);

            BigDecimal itemTotal = product.getPrice().multiply(BigDecimal.valueOf(itemDto.getQuantity()));

            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(savedOrder);
            orderItem.setProduct(product);
            orderItem.setQuantity(itemDto.getQuantity());
            orderItem.setPrice(itemTotal);

            orderItemRepository.save(orderItem);

            totalAmount = totalAmount.add(itemTotal);
        }

        savedOrder.setTotalAmount(totalAmount);

        return customerOrderRepository.save(savedOrder);
    }
}