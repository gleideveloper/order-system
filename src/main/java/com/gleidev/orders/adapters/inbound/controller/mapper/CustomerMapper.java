package com.gleidev.orders.adapters.inbound.controller.mapper;

import com.gleidev.orders.adapters.inbound.controller.request.CustomerRequest;
import com.gleidev.orders.adapters.inbound.controller.response.CustomerResponse;
import com.gleidev.orders.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "isValidCpf", ignore = true)
    Customer toCustomer(CustomerRequest customerRequest);

    CustomerResponse toCustomerResponse(Customer customer);

}
