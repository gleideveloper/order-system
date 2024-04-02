package com.gleidev.orders.application.core.usecase;

import com.gleidev.orders.application.core.domain.Order;
import com.gleidev.orders.application.ports.in.FindOrderByIdUseCasePort;
import com.gleidev.orders.application.ports.out.FindOrderByIdPort;

public class FindOrderByIdUseCase implements FindOrderByIdUseCasePort {

    private final FindOrderByIdPort findOrderByIdPort;

    public FindOrderByIdUseCase(FindOrderByIdPort findOrderByIdPort) {
        this.findOrderByIdPort = findOrderByIdPort;
    }

    @Override
    public Order find(String id) {
        return findOrderByIdPort.find(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

}
