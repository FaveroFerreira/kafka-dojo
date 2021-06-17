package com.github.faveroferreira.order.controller;

import com.github.faveroferreira.order.business.facade.ProcessSubmittedOrderFacade;
import com.github.faveroferreira.order.dto.SubmittedOrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private ProcessSubmittedOrderFacade submittedOrderProcessor;

    @PostMapping("/order/submit")
    public void receiveSubmittedOrder(SubmittedOrderDTO submittedOrderDTO) {
        submittedOrderProcessor.processSubmittedOrder(submittedOrderDTO);
    }

}
