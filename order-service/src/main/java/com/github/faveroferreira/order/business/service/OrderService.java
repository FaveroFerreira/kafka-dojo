package com.github.faveroferreira.order.business.service;

import com.github.faveroferreira.order.dto.SubmittedOrderDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderService {

    public String persistSubmittedOrder(SubmittedOrderDTO submittedOrderDTO) {
        // ...Gera Entity
        // ...Persiste no banco
        // ...Retorna ID
        return UUID.randomUUID().toString();
    }

}
