package com.arantes.payment.adapters.out.repository.mapper;

import com.arantes.payment.adapters.out.repository.entity.PaymentEntity;
import com.arantes.payment.application.core.domain.Payment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentEntityMapper {

    PaymentEntity toPaymentEntity(Payment payment);
}
