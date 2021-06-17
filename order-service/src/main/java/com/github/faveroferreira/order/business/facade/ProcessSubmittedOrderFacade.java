package com.github.faveroferreira.order.business.facade;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.faveroferreira.order.business.service.OrderService;
import com.github.faveroferreira.order.dto.SubmittedOrderDTO;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProcessSubmittedOrderFacade {

    @Autowired
    private OrderService orderService;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void processSubmittedOrder(SubmittedOrderDTO submittedOrderDTO) {
        final String persistedOrderId = orderService.persistSubmittedOrder(submittedOrderDTO);
        submittedOrderDTO.setOrderId(persistedOrderId);
        publishOrderSubmittedEvent(submittedOrderDTO);
    }

    @SneakyThrows
    private void publishOrderSubmittedEvent(SubmittedOrderDTO submittedOrderDTO) {
        String json = new ObjectMapper().writeValueAsString(submittedOrderDTO);
        kafkaTemplate.send("order.submitted", json);
    }

}
