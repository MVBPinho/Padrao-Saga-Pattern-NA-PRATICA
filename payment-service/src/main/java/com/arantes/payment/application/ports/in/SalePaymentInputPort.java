package com.arantes.payment.application.ports.in;

import com.arantes.payment.application.core.domain.Sale;

public interface SalePaymentInputPort {

    void payment(Sale sale);
}
