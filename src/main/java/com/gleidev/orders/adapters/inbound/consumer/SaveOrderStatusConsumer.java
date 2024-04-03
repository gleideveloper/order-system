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

    private static final Logger LOGGER = LoggerFactory.getLogger(SaveOrderStatusConsumer.class);
    private static final String ORDER_STATUS = "ENVIADO_TRANSPORTADORA";

    @Autowired
    private UpdateOrderUseCasePort updateOrderUseCasePort;

    @KafkaListener(topics = "tp-order-status", groupId = "gleidev")
    public void receive(Order order) {
        if (order.getOrderMessage() != null) {
            LOGGER.info("Save {}", order);
            LOGGER.info("Order Message:: {}", order.getOrderMessage());
        }
        if (order.getId() != null){
            LOGGER.info("Description {}", order);
            order.setStatus(ORDER_STATUS);
            updateOrderUseCasePort.update(order);
        }
    }

}
