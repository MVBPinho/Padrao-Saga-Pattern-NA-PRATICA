package com.arantes.inventory.config.usecase;

import com.arantes.inventory.adapters.out.SendToKafkaAdapter;
import com.arantes.inventory.adapters.out.UpdatedInventoryAdapter;
import com.arantes.inventory.application.core.usecase.DebitInventoryUseCase;
import com.arantes.inventory.application.core.usecase.FindInventoryByProductIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DebitInventoryConfig {

    @Bean
    public DebitInventoryUseCase debitInventoryUseCase(
            FindInventoryByProductIdUseCase findInventoryByProductIdUseCase,
            UpdatedInventoryAdapter updatedInventoryAdapter,
            SendToKafkaAdapter sendToKafkaAdapter){
        return new DebitInventoryUseCase(findInventoryByProductIdUseCase, updatedInventoryAdapter, sendToKafkaAdapter);
    }
}
