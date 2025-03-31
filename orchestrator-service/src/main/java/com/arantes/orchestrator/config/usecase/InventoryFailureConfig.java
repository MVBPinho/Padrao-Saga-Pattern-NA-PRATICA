package com.arantes.orchestrator.config.usecase;

import com.arantes.orchestrator.adapters.out.SendSaleToTopicAdapter;
import com.arantes.orchestrator.application.core.usecase.InventoryFailureUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InventoryFailureConfig {

    @Bean
    public InventoryFailureUseCase inventoryFailureUseCase(SendSaleToTopicAdapter sendSaleToTopicAdapter) {
        return new InventoryFailureUseCase(sendSaleToTopicAdapter);
    }
}
