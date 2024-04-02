package com.gleidev.orders.adapters.outbound;

import com.gleidev.orders.adapters.outbound.respository.CustomerRepository;
import com.gleidev.orders.adapters.outbound.respository.mapper.CustomerEntityMapper;
import com.gleidev.orders.application.core.domain.Customer;
import com.gleidev.orders.application.ports.out.SaveCustomerPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveCustomerAdapter implements SaveCustomerPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public void save(Customer customer) {
        var customerEntity = customerEntityMapper.toCustomerEntity(customer);
        customerRepository.save(customerEntity);
    }

}
