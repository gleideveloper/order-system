package com.gleidev.orders.application.ports.out;

import com.gleidev.orders.application.core.domain.Order;

import java.util.Optional;

public interface FindOrderByIdPort {

    Optional<Order> find(String id);

}
