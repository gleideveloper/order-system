package com.gleidev.orders.config;

import com.gleidev.orders.adapters.outbound.SaveOrderAdapter;
import com.gleidev.orders.application.core.usecase.SaveOrderUseCase;
import com.gleidev.orders.application.ports.out.SendOrderStatusPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SaveOrderConfig {

    @Bean
    public SaveOrderUseCase saveOrderUseCase(SaveOrderAdapter saveOrderAdapter,
                                             SendOrderStatusPort sendOrderStatusPort){
        return new SaveOrderUseCase(saveOrderAdapter, sendOrderStatusPort);
    }
}
