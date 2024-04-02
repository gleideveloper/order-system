package com.gleidev.orders.adapters.inbound.consumer.mapper;

import com.gleidev.orders.adapters.inbound.consumer.message.CustomerMessage;
import com.gleidev.orders.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMessageMapper {

    @Mapping(target = "address", ignore = true)
    Customer toCustomer(CustomerMessage customerMessage);

}
