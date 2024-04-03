package com.gleidev.orders.config;

import com.gleidev.orders.adapters.outbound.SaveOrderAdapter;
import com.gleidev.orders.adapters.outbound.SendOrdeStatusAdapter;
import com.gleidev.orders.application.core.usecase.SaveOrderUseCase;
import com.gleidev.orders.application.ports.out.SendOrderStatusPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SaveOrderConfig {

    @Bean
    public SaveOrderUseCase saveOrderUseCase(SaveOrderAdapter saveOrderAdapter,
                                             SendOrdeStatusAdapter sendOrdeStatusAdapter){
        return new SaveOrderUseCase(saveOrderAdapter, sendOrdeStatusAdapter);
    }
}
