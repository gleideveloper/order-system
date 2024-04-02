package com.gleidev.orders.adapters.outbound;

import com.gleidev.orders.adapters.outbound.respository.OrderRepository;
import com.gleidev.orders.adapters.outbound.respository.mapper.OrderEntityMapper;
import com.gleidev.orders.application.core.domain.Order;
import com.gleidev.orders.application.ports.out.SaveOrderPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveOrderAdapter implements SaveOrderPort {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderEntityMapper orderEntityMapper;

    @Override
    public void save(Order order) {
        var orderEntity = orderEntityMapper.toOrderEntity(order);
        orderRepository.save(orderEntity);
    }
}
