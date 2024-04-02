package com.gleidev.orders.adapters.inbound.controller.mapper;

import com.gleidev.orders.adapters.inbound.controller.request.CustomerRequest;
import com.gleidev.orders.adapters.inbound.controller.request.OrderRequest;
import com.gleidev.orders.adapters.inbound.controller.response.CustomerResponse;
import com.gleidev.orders.adapters.inbound.controller.response.OrderResponse;
import com.gleidev.orders.application.core.domain.Customer;
import com.gleidev.orders.application.core.domain.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    Order toOrder(OrderRequest orderRequest);

    OrderResponse toOrderResponse(Order order);

}
