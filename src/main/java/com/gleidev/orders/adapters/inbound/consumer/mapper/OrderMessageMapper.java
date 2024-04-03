package com.gleidev.orders.adapters.inbound.consumer.mapper;

import com.gleidev.orders.adapters.inbound.consumer.message.OrderMessage;
import com.gleidev.orders.application.core.domain.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMessageMapper {

    Order toOrder(OrderMessage orderMessage);
    OrderMessage toMessage(Order order);

}
