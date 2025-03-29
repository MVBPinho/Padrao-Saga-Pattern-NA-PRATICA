package com.arantes.sale.application.core.usecase;

import com.arantes.sale.application.core.domain.Sale;
import com.arantes.sale.application.ports.in.FindSaleByIdInputPort;
import com.arantes.sale.application.ports.out.FindSaleByIdOutputPort;

public class FindSaleByIdUseCase implements FindSaleByIdInputPort {

    private final FindSaleByIdOutputPort findSaleByIdOutputPort;

    public FindSaleByIdUseCase(FindSaleByIdOutputPort findSaleByIdOutputPort) {
        this.findSaleByIdOutputPort = findSaleByIdOutputPort;
    }

    @Override
    public Sale find(final Integer id) {
         return findSaleByIdOutputPort.find(id)
                 .orElseThrow(() -> new RuntimeException("Venda não encontrada!"));
    }
}
