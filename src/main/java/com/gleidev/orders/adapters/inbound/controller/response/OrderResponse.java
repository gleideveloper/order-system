package com.gleidev.orders.adapters.inbound.controller.response;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class OrderResponse {

    private String status;

    private String description;

}
