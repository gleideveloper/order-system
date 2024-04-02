package com.gleidev.orders.adapters.inbound.consumer;

import com.gleidev.orders.adapters.inbound.consumer.mapper.CustomerMessageMapper;
import com.gleidev.orders.adapters.inbound.consumer.message.CustomerMessage;
import com.gleidev.orders.application.ports.in.UpdateCustomerUseCasePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiveValidatedCpfConsumer {

    @Autowired
    private UpdateCustomerUseCasePort updateCustomerUseCasePort;

    @Autowired
    private CustomerMessageMapper customerMessageMapper;

    @KafkaListener(topics = "tp-cpf-validated", groupId = "gleidev")
    public void receive(CustomerMessage customerMessage) {
        var customer = customerMessageMapper.toCustomer(customerMessage);
        updateCustomerUseCasePort.update(customer, customerMessage.getZipCode());
    }

}
