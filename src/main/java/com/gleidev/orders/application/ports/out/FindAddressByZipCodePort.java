package com.gleidev.orders.application.ports.out;

import com.gleidev.orders.application.core.domain.Address;

public interface FindAddressByZipCodePort {

    Address find(String zipCode);

}
