package com.gleidev.orders.application.core.usecase;

import com.gleidev.orders.application.core.domain.Order;
import com.gleidev.orders.application.ports.in.FindOrderByIdUseCasePort;
import com.gleidev.orders.application.ports.in.UpdateOrderUseCasePort;
import com.gleidev.orders.application.ports.out.UpdateOrderPort;

public class UpdateOrderUseCase implements UpdateOrderUseCasePort {

    private final FindOrderByIdUseCasePort findOrderByIdUseCasePort;
    private final UpdateOrderPort updateOrderPort;

    public UpdateOrderUseCase(FindOrderByIdUseCasePort findOrderByIdUseCasePort, UpdateOrderPort updateOrderPort) {
        this.findOrderByIdUseCasePort = findOrderByIdUseCasePort;
        this.updateOrderPort = updateOrderPort;
    }

    @Override
    public void update(Order order) {
        findOrderByIdUseCasePort.find(order.getId());
        updateOrderPort.update(order);
    }
}
