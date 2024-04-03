package com.gleidev.orders.adapters.inbound.consumer;

import com.gleidev.orders.adapters.inbound.consumer.mapper.OrderMessageMapper;
import com.gleidev.orders.adapters.inbound.consumer.message.OrderMessage;
import com.gleidev.orders.application.core.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class SaveOrderStatusConsumer {

//    @Autowired
//    private UpdateCustomerUseCasePort updateCustomerUseCasePort;
    @Autowired
    private OrderMessageMapper orderMessageMapper;

    @KafkaListener(topics = "tp-order-status", groupId = "gleidev")
    public void receive(Order order) {
//        updateCustomerUseCasePort.update(customer, customerMessage.getZipCode());
        System.out.println(order.getStatus());
    }

}
