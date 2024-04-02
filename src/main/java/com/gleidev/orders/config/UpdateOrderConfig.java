package com.gleidev.orders.config;

import com.gleidev.orders.adapters.outbound.UpdateOrderAdapter;
import com.gleidev.orders.application.core.usecase.FindOrderByIdUseCase;
import com.gleidev.orders.application.core.usecase.UpdateOrderUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateOrderConfig {

    @Bean
    public UpdateOrderUseCase updateOrderUseCase(FindOrderByIdUseCase findOrderByIdUseCase,
                                                 UpdateOrderAdapter updateOrderAdapter) {
        return new UpdateOrderUseCase(findOrderByIdUseCase, updateOrderAdapter);
    }

}
