package com.arantes.inventory.application.core.usecase;

import com.arantes.inventory.application.core.domain.Sale;
import com.arantes.inventory.application.core.domain.enums.SaleEvent;
import com.arantes.inventory.application.ports.in.FindInventoryByProductIdInputPort;
import com.arantes.inventory.application.ports.out.SendUpdateInventoryOutputPort;
import com.arantes.inventory.application.ports.out.UpdateInventoryOutputPort;

public class DebitInventoryUseCase {

    private final FindInventoryByProductIdInputPort findInventoryByProductIdInputPort;
    private final UpdateInventoryOutputPort updateInventoryOutputPort;
    private final SendUpdateInventoryOutputPort sendUpdateInventoryOutputPort;

    public DebitInventoryUseCase(
            FindInventoryByProductIdInputPort findInventoryByProductIdInputPort,
            UpdateInventoryOutputPort updateInventoryOutputPort,
            SendUpdateInventoryOutputPort sendUpdateInventoryOutputPort){
        this.findInventoryByProductIdInputPort = findInventoryByProductIdInputPort;
        this.updateInventoryOutputPort = updateInventoryOutputPort;
        this.sendUpdateInventoryOutputPort = sendUpdateInventoryOutputPort;
    }

    public void debit(Sale sale){
        var inventory = findInventoryByProductIdInputPort.find(sale.getProductId());
        if(inventory.getQuantity() < sale.getQuantity()) {
            throw new RuntimeException("Estoque insuficiente");
        }
        inventory.debitQuantity(sale.getQuantity());
        updateInventoryOutputPort.update(inventory);
        sendUpdateInventoryOutputPort.send(sale, SaleEvent.UPDATED_INVENTORY);
    }
}
