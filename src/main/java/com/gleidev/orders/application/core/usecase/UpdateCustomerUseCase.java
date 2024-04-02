package com.gleidev.orders.application.core.usecase;

import com.gleidev.orders.application.core.domain.Customer;
import com.gleidev.orders.application.ports.in.FindCustomerByIdUseCasePort;
import com.gleidev.orders.application.ports.in.UpdateCustomerUseCasePort;
import com.gleidev.orders.application.ports.out.FindAddressByZipCodePort;
import com.gleidev.orders.application.ports.out.UpdateCustomerPort;

public class UpdateCustomerUseCase implements UpdateCustomerUseCasePort {

    private final FindCustomerByIdUseCasePort findCustomerByIdUseCasePort;

    private final FindAddressByZipCodePort findAddressByZipCodePort;

    private final UpdateCustomerPort updateCustomerPort;

    public UpdateCustomerUseCase(FindCustomerByIdUseCasePort findCustomerByIdUseCasePort,
                                 FindAddressByZipCodePort findAddressByZipCodePort,
                                 UpdateCustomerPort updateCustomerPort) {
        this.findCustomerByIdUseCasePort = findCustomerByIdUseCasePort;
        this.findAddressByZipCodePort = findAddressByZipCodePort;
        this.updateCustomerPort = updateCustomerPort;
    }

    @Override
    public void update(Customer customer, String zipCode) {
        findCustomerByIdUseCasePort.find(customer.getId());
        var address = findAddressByZipCodePort.find(zipCode);
        customer.setAddress(address);
        updateCustomerPort.update(customer);
    }

}
