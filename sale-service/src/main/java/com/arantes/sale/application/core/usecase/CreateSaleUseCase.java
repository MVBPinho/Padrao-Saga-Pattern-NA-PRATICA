package com.arantes.sale.application.core.usecase;

import com.arantes.sale.application.core.domain.enums.SaleEvent;
import com.arantes.sale.application.core.domain.enums.SaleStatus;
import com.arantes.sale.application.core.domain.Sale;
import com.arantes.sale.application.ports.in.CreateSaleInputPort;
import com.arantes.sale.application.ports.out.SaveSaleOutputPort;
import com.arantes.sale.application.ports.out.SendCreatedSaleOutputPort;

public class CreateSaleUseCase implements CreateSaleInputPort {

    private final SaveSaleOutputPort saveSaleOutputPort;
    private final SendCreatedSaleOutputPort sendCreatedSaleOutputPort;

    public CreateSaleUseCase(
            SaveSaleOutputPort saveSaleOutputPort,
            SendCreatedSaleOutputPort sendCreatedSaleOutputPort) {
        this.saveSaleOutputPort = saveSaleOutputPort;
        this.sendCreatedSaleOutputPort = sendCreatedSaleOutputPort;
    }

    @Override
    public void create(Sale sale) {
        sale.setStatus(SaleStatus.PENDING);
        var saleResponse = saveSaleOutputPort.save(sale);
        sendCreatedSaleOutputPort.send(saleResponse, SaleEvent.CREATED_SALE);
    }
}
