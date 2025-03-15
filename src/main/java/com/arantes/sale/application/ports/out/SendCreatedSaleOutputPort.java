package com.arantes.sale.application.ports.out;

import com.arantes.sale.application.core.domain.Sale;
import com.arantes.sale.application.core.domain.enums.SaleEvent;

public interface SendCreatedSaleOutputPort {

    void send(Sale sale, SaleEvent event);
}
