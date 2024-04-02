package com.gleidev.orders.adapters.outbound;

import com.gleidev.orders.adapters.outbound.respository.OrderRepository;
import com.gleidev.orders.adapters.outbound.respository.mapper.OrderEntityMapper;
import com.gleidev.orders.application.core.domain.Order;
import com.gleidev.orders.application.ports.out.FindOrderByIdPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindOrderByIdAdapter implements FindOrderByIdPort {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderEntityMapper orderEntityMapper;

    @Override
    public Optional<Order> find(String id) {
        var orderEntity = orderRepository.findById(id);
        return orderEntity.map(entity -> orderEntityMapper.toOrder(entity));
    }

}
