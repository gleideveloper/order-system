package com.gleidev.orders.adapters.outbound.respository.mapper;

import com.gleidev.orders.adapters.outbound.respository.entity.CustomerEntity;
import com.gleidev.orders.application.core.domain.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {

    CustomerEntity toCustomerEntity(Customer customer);

    Customer toCustomer(CustomerEntity customerEntity);

}
