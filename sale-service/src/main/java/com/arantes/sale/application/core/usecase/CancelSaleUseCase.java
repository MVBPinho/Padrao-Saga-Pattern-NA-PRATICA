package com.arantes.sale.application.core.usecase;

import com.arantes.sale.application.core.domain.Sale;
import com.arantes.sale.application.core.domain.enums.SaleStatus;
import com.arantes.sale.application.ports.in.CancelSaleInputPort;
import com.arantes.sale.application.ports.in.FindSaleByIdInputPort;
import com.arantes.sale.application.ports.out.SaveSaleOutputPort;

public class CancelSaleUseCase implements CancelSaleInputPort {

    private final FindSaleByIdInputPort findSaleByIdInputPort;

    private final SaveSaleOutputPort saveSaleOutputPort;

    public CancelSaleUseCase(FindSaleByIdInputPort findSaleByIdInputPort,
                             SaveSaleOutputPort saveSaleOutputPort){
        this.findSaleByIdInputPort = findSaleByIdInputPort;
        this.saveSaleOutputPort = saveSaleOutputPort;
    }

    @Override
    public void cancel(Sale sale) {
        var saleResponse = findSaleByIdInputPort.find(sale.getId());
        saleResponse.setStatus(SaleStatus.CANCELED);
        saveSaleOutputPort.save(saleResponse);
    }
}
