package com.gleidev.orders.application.core.usecase;

import com.gleidev.orders.application.core.domain.Customer;
import com.gleidev.orders.application.ports.in.FindCustomerByIdUseCasePort;
import com.gleidev.orders.application.ports.out.FindCustomerByIdPort;

public class FindCustomerByIdUseCase implements FindCustomerByIdUseCasePort {

    private final FindCustomerByIdPort findCustomerByIdPort;

    public FindCustomerByIdUseCase(FindCustomerByIdPort findCustomerByIdPort) {
        this.findCustomerByIdPort = findCustomerByIdPort;
    }

    @Override
    public Customer find(String id) {
        return findCustomerByIdPort.find(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }

}
