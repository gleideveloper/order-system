package com.gleidev.orders.config;

import com.gleidev.orders.adapters.outbound.FindAddressByZipCodeAdapter;
import com.gleidev.orders.adapters.outbound.UpdateCustomerAdapter;
import com.gleidev.orders.application.core.usecase.FindCustomerByIdUseCase;
import com.gleidev.orders.application.core.usecase.UpdateCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {

    @Bean
    public UpdateCustomerUseCase updateCustomerUseCase(FindCustomerByIdUseCase findCustomerByIdUseCase,
                                                       FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
                                                       UpdateCustomerAdapter updateCustomerAdapter) {
        return new UpdateCustomerUseCase(findCustomerByIdUseCase, findAddressByZipCodeAdapter, updateCustomerAdapter);
    }

}
