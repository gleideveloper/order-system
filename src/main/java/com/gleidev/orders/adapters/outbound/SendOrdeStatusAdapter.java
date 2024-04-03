package com.gleidev.orders.adapters.outbound;

import com.gleidev.orders.application.core.domain.Order;
import com.gleidev.orders.application.ports.out.SendOrderStatusPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SendOrdeStatusAdapter implements SendOrderStatusPort {

    @Autowired
    private KafkaTemplate<String, Order> kafkaTemplate;

    @Override
    public void send(Order order) {
        kafkaTemplate.send("tp-order-status", order);
    }

}
