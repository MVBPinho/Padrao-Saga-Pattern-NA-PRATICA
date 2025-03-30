package com.arantes.sale.config.usecase;

import com.arantes.sale.application.core.usecase.CancelSaleUseCase;
import com.arantes.sale.application.ports.in.FindSaleByIdInputPort;
import com.arantes.sale.application.ports.out.SaveSaleOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CancelSaleConfig {

    @Bean
    public CancelSaleUseCase cancelSaleUseCase(FindSaleByIdInputPort findSaleByIdInputPort,
                                               SaveSaleOutputPort saveSaleOutputPort) {
        return new CancelSaleUseCase(findSaleByIdInputPort, saveSaleOutputPort);

    }
}
