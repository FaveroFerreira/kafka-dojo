package com.github.faveroferreira.order.controller;

import com.github.faveroferreira.order.business.facade.ProcessSubmittedOrderFacade;
import com.github.faveroferreira.order.dto.SubmittedOrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class OrderController {

    @Autowired
    private ProcessSubmittedOrderFacade submittedOrderProcessor;

    @PostMapping("/order/submit")
    public void receiveSubmittedOrder(@RequestBody SubmittedOrderDTO submittedOrderDTO) {
        log.info("M=receiveSubmittedOrder, message=Received submitted order: {}", submittedOrderDTO);
        submittedOrderProcessor.processSubmittedOrder(submittedOrderDTO);
    }

}
