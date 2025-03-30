package com.arantes.inventory.application.ports.in;

import com.arantes.inventory.application.core.domain.Sale;

public interface CreditInventoryInputPort {

    void credit(Sale sale);
}
