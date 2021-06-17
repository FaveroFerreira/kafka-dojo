package com.github.faveroferreira.order.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SubmittedOrderDTO {

    private String orderId;
    private CustomerDTO customer;
    private OrderPaymentInfoDTO paymentInfo;
    private List<OrderItemDTO> items = new ArrayList<>();

    public Double orderTotal() {
        return this.items.stream()
                .mapToDouble(OrderItemDTO::itemTotal)
                .sum();
    }

}
