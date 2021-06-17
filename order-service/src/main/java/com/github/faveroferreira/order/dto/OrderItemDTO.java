package com.github.faveroferreira.order.dto;

import java.math.BigDecimal;

public class OrderItemDTO {

    private String itemName;
    private Integer quantity;
    private Double priceAmount;

    public Double itemTotal() {
        return quantity * priceAmount;
    }

}
