package com.gleidev.orders.adapters.outbound.respository;

import com.gleidev.orders.adapters.outbound.respository.entity.CustomerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<CustomerEntity, String> {
}
