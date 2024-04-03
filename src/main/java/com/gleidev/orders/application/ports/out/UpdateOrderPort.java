package com.gleidev.orders.application.ports.out;

import com.gleidev.orders.application.core.domain.Order;

public interface UpdateOrderPort {

    void update(Order order);

}
