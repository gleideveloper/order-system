package com.gleidev.orders.adapters.outbound.respository.mapper;

import com.gleidev.orders.adapters.outbound.respository.entity.CustomerEntity;
import com.gleidev.orders.adapters.outbound.respository.entity.OrderEntity;
import com.gleidev.orders.application.core.domain.Customer;
import com.gleidev.orders.application.core.domain.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderEntityMapper {

    OrderEntity toOrderEntity(Order order);

    Order toOrder(OrderEntity orderEntity);

}
