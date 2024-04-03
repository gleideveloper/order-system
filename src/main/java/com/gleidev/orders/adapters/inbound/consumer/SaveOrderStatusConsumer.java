package com.gleidev.orders.adapters.inbound.consumer;

import com.gleidev.orders.application.core.domain.Order;
import com.gleidev.orders.application.ports.in.UpdateOrderUseCasePort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class SaveOrderStatusConsumer {
    Logger logger = LoggerFactory.getLogger(SaveOrderStatusConsumer.class);
    @Autowired
    private UpdateOrderUseCasePort updateOrderUseCasePort;

    @KafkaListener(topics = "tp-order-status", groupId = "gleidev")
    public void receive(Order order) {
        if (order.getOrderMessage() != null) {
            logger.info("Save {}", order);
            logger.info("Order Message:: {}", order.getOrderMessage());
        }
        if (order.getId() != null){
            logger.info("Description {}", order);
            order.setStatus("ENVIADO_TRANSPORTADORA");
            updateOrderUseCasePort.update(order);
        }
    }

}
