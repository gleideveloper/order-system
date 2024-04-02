package com.gleidev.orders.adapters.outbound.respository.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "orders")
public class OrderEntity {

    @Id
    private String id;
    private String status;
    private String description;

}
