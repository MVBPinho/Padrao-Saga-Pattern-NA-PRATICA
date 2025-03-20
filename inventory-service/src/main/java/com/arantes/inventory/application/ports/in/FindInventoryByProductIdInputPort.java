package com.arantes.inventory.application.ports.in;

import com.arantes.inventory.application.core.domain.Inventory;

public interface FindInventoryByProductIdInputPort {

    Inventory find(Integer productId);
}
