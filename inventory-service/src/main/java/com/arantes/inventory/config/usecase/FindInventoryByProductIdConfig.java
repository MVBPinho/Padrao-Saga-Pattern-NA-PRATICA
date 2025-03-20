package com.arantes.inventory.config.usecase;

import com.arantes.inventory.adapters.out.FindInventoryByProductIdAdapter;
import com.arantes.inventory.application.core.usecase.FindInventoryByProductIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindInventoryByProductIdConfig {

    @Bean
    public FindInventoryByProductIdUseCase findInventoryByProductIdUseCase(
            FindInventoryByProductIdAdapter findInventoryByProductIdAdapter){
        return new FindInventoryByProductIdUseCase(findInventoryByProductIdAdapter);
    }

}
