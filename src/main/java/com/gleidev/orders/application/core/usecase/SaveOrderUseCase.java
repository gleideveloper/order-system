package com.gleidev.orders.application.core.usecase;

import com.gleidev.orders.application.core.domain.Order;
import com.gleidev.orders.application.ports.in.SaveOrderUseCasePort;
import com.gleidev.orders.application.ports.out.SaveOrderPort;
import com.gleidev.orders.application.ports.out.SendOrderStatusPort;

public class SaveOrderUseCase implements SaveOrderUseCasePort {

    private final String ORDER_MESSAGE = "novo pedido foi efetuado";
    private final SaveOrderPort saveOrderPort;

    private SendOrderStatusPort sendOrderStatusPort;

    public SaveOrderUseCase(SaveOrderPort saveOrderPort, SendOrderStatusPort sendOrderStatusPort) {
        this.saveOrderPort = saveOrderPort;
        this.sendOrderStatusPort = sendOrderStatusPort;
    }

    @Override
    public void save(Order order) {
        order.setOrderMessage(ORDER_MESSAGE);
        saveOrderPort.save(order);
        sendOrderStatusPort.send(order);
    }
}
