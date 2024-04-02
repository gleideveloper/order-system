package com.gleidev.orders.application.ports.in;

import com.gleidev.orders.application.core.domain.Customer;

public interface UpdateCustomerUseCasePort {

    void update(Customer customer, String zipCode);

}
