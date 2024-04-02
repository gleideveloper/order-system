package com.gleidev.orders.config;

import com.gleidev.orders.adapters.outbound.FindOrderByIdAdapter;
import com.gleidev.orders.application.core.usecase.FindOrderByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindOrderByIdConfig {


    @Bean
    public FindOrderByIdUseCase findOrderByIdUseCase(FindOrderByIdAdapter findOrderByIdAdapter){
        return new FindOrderByIdUseCase(findOrderByIdAdapter);
    }

}
