package com.gleidev.orders.adapters.outbound.client.mapper;

import com.gleidev.orders.adapters.outbound.client.response.AddressResponse;
import com.gleidev.orders.application.core.domain.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {

    Address toAddress(AddressResponse addressResponse);

}
