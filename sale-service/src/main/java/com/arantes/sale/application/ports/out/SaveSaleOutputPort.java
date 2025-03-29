package com.arantes.sale.application.ports.out;

import com.arantes.sale.application.core.domain.Sale;

public interface SaveSaleOutputPort {

    Sale save(Sale sale);
}
