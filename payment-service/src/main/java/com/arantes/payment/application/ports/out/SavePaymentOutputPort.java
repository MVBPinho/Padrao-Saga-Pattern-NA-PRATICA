package com.arantes.payment.application.ports.out;

import com.arantes.payment.application.core.domain.Payment;

public interface SavePaymentOutputPort {

    void save(Payment payment);
}
