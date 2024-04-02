package com.gleidev.orders.application.ports.in;

import com.gleidev.orders.application.core.domain.Order;

public interface SaveOrderUseCasePort {

    void save(Order order);

}
