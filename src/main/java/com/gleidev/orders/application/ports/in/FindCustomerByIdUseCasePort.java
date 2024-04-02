package com.gleidev.orders.application.ports.in;

import com.gleidev.orders.application.core.domain.Customer;

public interface FindCustomerByIdUseCasePort {

    Customer find(String id);

}
