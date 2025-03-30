package com.arantes.sale.application.ports.in;

import com.arantes.sale.application.core.domain.Sale;

public interface CancelSaleInputPort {

    void cancel(Sale sale);
}
