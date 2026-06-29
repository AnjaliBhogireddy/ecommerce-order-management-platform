package com.anjali.ecommerce_order_management_platform.dto;

import java.util.List;

public class OrderRequestDto {

    private Long customerId;
    private List<OrderItemRequestDto> items;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public List<OrderItemRequestDto> getItems() {
        return items;
    }

    public void setItems(List<OrderItemRequestDto> items) {
        this.items = items;
    }
}