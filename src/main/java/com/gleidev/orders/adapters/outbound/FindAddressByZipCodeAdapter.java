package com.gleidev.orders.adapters.outbound;

import com.gleidev.orders.adapters.outbound.client.FindAddressByZipCodeClient;
import com.gleidev.orders.adapters.outbound.client.mapper.AddressResponseMapper;
import com.gleidev.orders.application.core.domain.Address;
import com.gleidev.orders.application.ports.out.FindAddressByZipCodePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindAddressByZipCodeAdapter implements FindAddressByZipCodePort {

    @Autowired
    private FindAddressByZipCodeClient findAddressByZipCodeClient;

    @Autowired
    private AddressResponseMapper addressResponseMapper;

    @Override
    public Address find(String zipCode) {
        var addressResponse = findAddressByZipCodeClient.find(zipCode);
        return addressResponseMapper.toAddress(addressResponse);
    }

}
