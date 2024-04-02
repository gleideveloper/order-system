package com.gleidev.orders.application.core.usecase;

import com.gleidev.orders.application.core.domain.Customer;
import com.gleidev.orders.application.ports.in.SaveCustomerUseCasePort;
import com.gleidev.orders.application.ports.out.FindAddressByZipCodePort;
import com.gleidev.orders.application.ports.out.SaveCustomerPort;
import com.gleidev.orders.application.ports.out.SendCpfForValidationPort;

public class SaveCustomerUseCase implements SaveCustomerUseCasePort {

    private final FindAddressByZipCodePort findAddressByZipCodePort;

    private final SaveCustomerPort saveCustomerPort;

    private final SendCpfForValidationPort sendCpfForValidationPort;

    public SaveCustomerUseCase(FindAddressByZipCodePort findAddressByZipCodePort, SaveCustomerPort saveCustomerPort, SendCpfForValidationPort sendCpfForValidationPort) {
        this.findAddressByZipCodePort = findAddressByZipCodePort;
        this.saveCustomerPort = saveCustomerPort;
        this.sendCpfForValidationPort = sendCpfForValidationPort;
    }

    @Override
    public void save(Customer customer, String zipCode){
        var address = findAddressByZipCodePort.find(zipCode);
        customer.setAddress(address);
        saveCustomerPort.save(customer);
        sendCpfForValidationPort.send(customer.getCpf());
    }

}
