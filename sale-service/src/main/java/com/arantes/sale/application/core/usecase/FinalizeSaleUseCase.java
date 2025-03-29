package com.arantes.sale.application.core.usecase;

import com.arantes.sale.application.core.domain.Sale;
import com.arantes.sale.application.core.domain.enums.SaleStatus;
import com.arantes.sale.application.ports.in.FinalizeSaleInputPort;
import com.arantes.sale.application.ports.in.FindSaleByIdInputPort;
import com.arantes.sale.application.ports.out.SaveSaleOutputPort;

public class FinalizeSaleUseCase implements FinalizeSaleInputPort {

    private final FindSaleByIdInputPort findSaleByIdInputPort;

    private final SaveSaleOutputPort saveSaleOutputPort;

    public FinalizeSaleUseCase(FindSaleByIdInputPort findSaleByIdInputPort,
                               SaveSaleOutputPort saveSaleOutputPort) {
        this.findSaleByIdInputPort = findSaleByIdInputPort;
        this.saveSaleOutputPort = saveSaleOutputPort;
    }

    @Override
    public void finalize(Sale sale) {
        var saleReponse = findSaleByIdInputPort.find(sale.getId());
        saleReponse.setStatus(SaleStatus.FINALIZED);
        saveSaleOutputPort.save(saleReponse);
    }
}
