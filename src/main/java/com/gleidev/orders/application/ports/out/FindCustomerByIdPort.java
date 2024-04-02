package com.gleidev.orders.application.ports.out;

import com.gleidev.orders.application.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerByIdPort {

    Optional<Customer> find(String id);

}
