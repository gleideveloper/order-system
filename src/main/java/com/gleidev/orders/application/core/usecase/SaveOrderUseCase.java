package com.gleidev.orders.application.core.usecase;

import com.gleidev.orders.application.core.domain.Order;
import com.gleidev.orders.application.ports.in.SaveOrderUseCasePort;
import com.gleidev.orders.application.ports.out.SaveOrderPort;

public class SaveOrderUseCase implements SaveOrderUseCasePort {

    private final SaveOrderPort saveOrderPort;

    public SaveOrderUseCase(SaveOrderPort saveOrderPort) {
        this.saveOrderPort = saveOrderPort;
    }

    @Override
    public void save(Order order) {
        saveOrderPort.save(order);
    }
}
