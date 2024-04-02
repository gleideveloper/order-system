package com.gleidev.orders.adapters.outbound;

import com.gleidev.orders.adapters.outbound.respository.CustomerRepository;
import com.gleidev.orders.application.ports.out.DeleteCustomerByIdPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteCustomerByIdAdapter implements DeleteCustomerByIdPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void delete(String id) {
        customerRepository.deleteById(id);
    }

}
