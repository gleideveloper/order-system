package com.gleidev.orders.application.ports.out;

import com.gleidev.orders.application.core.domain.Order;

public interface SaveOrderPort {

    void save(Order order);

}
