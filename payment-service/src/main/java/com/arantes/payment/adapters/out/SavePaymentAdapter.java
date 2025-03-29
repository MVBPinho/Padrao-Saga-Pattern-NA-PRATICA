package com.arantes.payment.adapters.out;

import com.arantes.payment.adapters.out.repository.PaymentRepository;
import com.arantes.payment.adapters.out.repository.mapper.PaymentEntityMapper;
import com.arantes.payment.application.core.domain.Payment;
import com.arantes.payment.application.ports.out.SavePaymentOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SavePaymentAdapter implements SavePaymentOutputPort {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private PaymentEntityMapper paymentEntityMapper;

    @Override
    public void save(Payment payment) {
        var paymentEntity = paymentEntityMapper.toPaymentEntity(payment);
        paymentRepository.save(paymentEntity);
    }
}
