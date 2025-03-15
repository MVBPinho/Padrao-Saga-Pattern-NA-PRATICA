package com.arantes.sale.application.ports.in;

import com.arantes.sale.application.core.domain.Sale;

public interface CreateSaleInputPort {

    void create(Sale sale);
}
