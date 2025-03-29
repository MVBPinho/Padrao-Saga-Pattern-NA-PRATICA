package com.arantes.sale.application.ports.out;

import com.arantes.sale.application.core.domain.Sale;

import java.util.Optional;

public interface FindSaleByIdOutputPort {

    Optional<Sale> find(final Integer id);
}
