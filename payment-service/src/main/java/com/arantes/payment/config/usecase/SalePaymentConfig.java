package com.arantes.payment.config.usecase;

import com.arantes.payment.adapters.out.SavePaymentAdapter;
import com.arantes.payment.adapters.out.SendValidatedPaymentAdapter;
import com.arantes.payment.adapters.out.UpdateUserAdapter;
import com.arantes.payment.application.core.usecase.FindUserByIdUseCase;
import com.arantes.payment.application.core.usecase.SalePaymentUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SalePaymentConfig {

    @Bean
    public SalePaymentUseCase salePaymentUseCase(
            FindUserByIdUseCase findUserByIdUseCase,
            UpdateUserAdapter updateUserAdapter,
            SavePaymentAdapter savePaymentAdapter,
            SendValidatedPaymentAdapter sendValidatedPaymentAdapter
    ) {
        return new SalePaymentUseCase(findUserByIdUseCase, updateUserAdapter, savePaymentAdapter, sendValidatedPaymentAdapter);
    }

}
