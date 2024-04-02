package com.gleidev.orders.application.core.usecase;

import com.gleidev.orders.application.ports.in.DeleteCustomerByIdUseCasePort;
import com.gleidev.orders.application.ports.in.FindCustomerByIdUseCasePort;
import com.gleidev.orders.application.ports.out.DeleteCustomerByIdPort;

public class DeleteCustomerByIdUseCase implements DeleteCustomerByIdUseCasePort {

    private final FindCustomerByIdUseCasePort findCustomerByIdUseCasePort;

    private final DeleteCustomerByIdPort deleteCustomerByIdPort;

    public DeleteCustomerByIdUseCase(FindCustomerByIdUseCasePort findCustomerByIdUseCasePort,
                                     DeleteCustomerByIdPort deleteCustomerByIdPort) {
        this.findCustomerByIdUseCasePort = findCustomerByIdUseCasePort;
        this.deleteCustomerByIdPort = deleteCustomerByIdPort;
    }

    @Override
    public void delete(final String id) {
        findCustomerByIdUseCasePort.find(id);
        deleteCustomerByIdPort.delete(id);
    }

}
