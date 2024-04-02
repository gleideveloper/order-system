package com.gleidev.orders.adapters.outbound.respository;

import com.gleidev.orders.adapters.outbound.respository.entity.CustomerEntity;
import com.gleidev.orders.adapters.outbound.respository.entity.OrderEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<OrderEntity, String> {
}
