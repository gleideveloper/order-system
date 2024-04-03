package com.gleidev.orders.application.ports.out;

import com.gleidev.orders.adapters.inbound.consumer.message.OrderMessage;
import com.gleidev.orders.application.core.domain.Order;

public interface SendOrderStatusPort {

    void send(Order order);

}
