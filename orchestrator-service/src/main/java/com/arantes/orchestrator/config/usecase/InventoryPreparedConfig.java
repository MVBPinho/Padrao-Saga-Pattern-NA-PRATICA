package com.arantes.orchestrator.config.usecase;

import com.arantes.orchestrator.adapters.out.SendSaleToTopicAdapter;
import com.arantes.orchestrator.application.core.usecase.InventoryPreparedUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InventoryPreparedConfig {

    @Bean
    public InventoryPreparedUseCase inventoryPreparedUseCase(SendSaleToTopicAdapter sendSaleToTopicAdapter) {
        return new InventoryPreparedUseCase(sendSaleToTopicAdapter);
    }
}
