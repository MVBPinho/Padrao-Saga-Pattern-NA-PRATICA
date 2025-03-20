package com.arantes.inventory.application.ports.out;

import com.arantes.inventory.application.core.domain.Inventory;

public interface UpdateInventoryOutputPort {

    void update(Inventory inventory);
}
