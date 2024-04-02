package com.gleidev.orders.adapters.inbound.controller.request;

import lombok.Data;

import jakarta.validation.constraints.NotBlank;

@Data
public class CustomerRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String cpf;

    @NotBlank
    private String zipCode;

}
