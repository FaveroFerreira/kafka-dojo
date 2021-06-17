package com.github.faveroferreira.email.kafka;

import com.github.faveroferreira.order.dto.SubmittedOrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderSubmittedEventProcessor {

    @KafkaListener(topics = "order.submitted", groupId = "${spring.kafka.consumer.group-id}")
    public void processEvent(SubmittedOrderDTO event) {
        log.info("M=processEvent, message=envet = {}", event);
    }

}
