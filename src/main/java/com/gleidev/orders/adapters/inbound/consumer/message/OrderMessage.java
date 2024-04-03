package com.gleidev.orders.adapters.inbound.consumer.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderMessage {

    private String id;
    private String status;
    private String description;

}
