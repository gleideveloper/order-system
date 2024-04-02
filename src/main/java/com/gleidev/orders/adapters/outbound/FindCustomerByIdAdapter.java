package com.gleidev.orders.adapters.outbound;

import com.gleidev.orders.adapters.outbound.respository.CustomerRepository;
import com.gleidev.orders.adapters.outbound.respository.mapper.CustomerEntityMapper;
import com.gleidev.orders.application.core.domain.Customer;
import com.gleidev.orders.application.ports.out.FindCustomerByIdPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindCustomerByIdAdapter implements FindCustomerByIdPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public Optional<Customer> find(String id) {
        var customerEntity = customerRepository.findById(id);
        return customerEntity.map(entity -> customerEntityMapper.toCustomer(entity));
    }

}
