package com.gleidev.orders.adapters.inbound.controller.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class OrderRequest {

    @NotBlank
    private String status;

    @NotBlank
    private String description;

}
