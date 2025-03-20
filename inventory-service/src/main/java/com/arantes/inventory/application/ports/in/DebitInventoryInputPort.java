package com.arantes.inventory.application.ports.in;

import com.arantes.inventory.application.core.domain.Sale;

public interface DebitInventoryInputPort {

    void debit(Sale sale);
}
