package com.github.faveroferreira.order.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SubmittedOrderDTO {

    private String orderId;
    private com.github.faveroferreira.order.dto.CustomerDTO customer;
    private com.github.faveroferreira.order.dto.OrderPaymentInfoDTO paymentInfo;
    private List<com.github.faveroferreira.order.dto.OrderItemDTO> items = new ArrayList<>();

    public Double orderTotal() {
        return this.items.stream()
                .mapToDouble(com.github.faveroferreira.order.dto.OrderItemDTO::itemTotal)
                .sum();
    }

}
