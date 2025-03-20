package com.arantes.payment.application.ports.out;

import com.arantes.payment.application.core.domain.Sale;

public interface SalePaymentOutputPort {

    void payment(Sale sale);
}
