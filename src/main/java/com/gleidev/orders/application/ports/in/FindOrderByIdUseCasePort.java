package com.gleidev.orders.application.ports.in;

import com.gleidev.orders.application.core.domain.Order;

public interface FindOrderByIdUseCasePort {

    Order find(String id);

}
