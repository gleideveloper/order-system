package com.gleidev.orders.application.ports.out;

import com.gleidev.orders.application.core.domain.Customer;

public interface UpdateCustomerPort {

    void update(Customer customer);

}
