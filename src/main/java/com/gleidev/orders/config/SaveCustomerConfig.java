package com.gleidev.orders.config;

import com.gleidev.orders.adapters.outbound.FindAddressByZipCodeAdapter;
import com.gleidev.orders.adapters.outbound.SaveCustomerAdapter;
import com.gleidev.orders.adapters.outbound.SendCpfForValidationAdapter;
import com.gleidev.orders.application.core.usecase.SaveCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SaveCustomerConfig {

    @Bean
    public SaveCustomerUseCase saveCustomerUseCase(FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
                                                   SaveCustomerAdapter saveCustomerAdapter,
                                                   SendCpfForValidationAdapter sendCpfForValidationAdapter) {
        return new SaveCustomerUseCase(findAddressByZipCodeAdapter, saveCustomerAdapter, sendCpfForValidationAdapter);
    }

}
