package com.arantes.inventory.config.usecase;

import com.arantes.inventory.application.core.usecase.CreditInventoryUseCase;
import com.arantes.inventory.application.ports.in.FindInventoryByProductIdInputPort;
import com.arantes.inventory.application.ports.out.SendToKafkaOutputPort;
import com.arantes.inventory.application.ports.out.UpdateInventoryOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreditInventoryConfig {

    @Bean
    public CreditInventoryUseCase creditInventoryUseCase(FindInventoryByProductIdInputPort findInventoryByProductIdInputPort,
                                                         UpdateInventoryOutputPort updateInventoryOutputPort,
                                                         SendToKafkaOutputPort sendToKafkaOutputPort) {
        return new CreditInventoryUseCase(findInventoryByProductIdInputPort, updateInventoryOutputPort, sendToKafkaOutputPort);
    }
}
