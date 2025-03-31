package com.arantes.inventory.application.core.usecase;

import com.arantes.inventory.application.core.domain.Sale;
import com.arantes.inventory.application.ports.in.CreditInventoryInputPort;
import com.arantes.inventory.application.ports.in.FindInventoryByProductIdInputPort;
import com.arantes.inventory.application.ports.out.UpdateInventoryOutputPort;

public class CreditInventoryUseCase implements CreditInventoryInputPort {

    private final FindInventoryByProductIdInputPort findInventoryByProductIdInputPort;

    private final UpdateInventoryOutputPort updateInventoryOutputPort;

    public CreditInventoryUseCase(FindInventoryByProductIdInputPort findInventoryByProductIdInputPort,
                                  UpdateInventoryOutputPort updateInventoryOutputPort) {
        this.findInventoryByProductIdInputPort = findInventoryByProductIdInputPort;
        this.updateInventoryOutputPort = updateInventoryOutputPort;;
    }

    @Override
    public void credit(Sale sale) {
        var inventory = findInventoryByProductIdInputPort.find(sale.getProductId());
        inventory.creditQuantity(sale.getQuantity());
        updateInventoryOutputPort.update(inventory);
    }
}
