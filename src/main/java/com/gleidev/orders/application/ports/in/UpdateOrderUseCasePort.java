package com.gleidev.orders.application.ports.in;

import com.gleidev.orders.application.core.domain.Order;

public interface UpdateOrderUseCasePort {

    void update(Order order);

}
