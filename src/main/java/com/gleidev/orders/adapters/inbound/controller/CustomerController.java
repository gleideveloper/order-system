package com.gleidev.orders.adapters.inbound.controller;

import com.gleidev.orders.adapters.inbound.controller.mapper.CustomerMapper;
import com.gleidev.orders.adapters.inbound.controller.request.CustomerRequest;
import com.gleidev.orders.adapters.inbound.controller.response.CustomerResponse;
import com.gleidev.orders.application.core.domain.Customer;
import com.gleidev.orders.application.ports.in.DeleteCustomerByIdUseCasePort;
import com.gleidev.orders.application.ports.in.FindCustomerByIdUseCasePort;
import com.gleidev.orders.application.ports.in.SaveCustomerUseCasePort;
import com.gleidev.orders.application.ports.in.UpdateCustomerUseCasePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private SaveCustomerUseCasePort saveCustomerUseCasePort;

    @Autowired
    private FindCustomerByIdUseCasePort findCustomerByIdUseCasePort;

    @Autowired
    private UpdateCustomerUseCasePort updateCustomerUseCasePort;

    @Autowired
    private DeleteCustomerByIdUseCasePort deleteCustomerByIdUseCasePort;

    @Autowired
    private CustomerMapper customerMapper;

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest customerRequest) {
        var customer = customerMapper.toCustomer(customerRequest);
        saveCustomerUseCasePort.save(customer, customerRequest.getZipCode());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable final String id) {
        var customer = findCustomerByIdUseCasePort.find(id);
        var customerResponse = customerMapper.toCustomerResponse(customer);
        return ResponseEntity.ok().body(customerResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable final String id, @Valid @RequestBody CustomerRequest customerRequest) {
        Customer customer = customerMapper.toCustomer(customerRequest);
        customer.setId(id);
        updateCustomerUseCasePort.update(customer, customerRequest.getZipCode());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final String id) {
        deleteCustomerByIdUseCasePort.delete(id);
        return ResponseEntity.noContent().build();
    }

}
