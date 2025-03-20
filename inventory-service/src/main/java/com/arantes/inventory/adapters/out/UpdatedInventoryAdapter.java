package com.arantes.inventory.adapters.out;

import com.arantes.inventory.adapters.out.repository.InventoryRepository;
import com.arantes.inventory.adapters.out.repository.mapper.InventoryEntityMapper;
import com.arantes.inventory.application.core.domain.Inventory;
import com.arantes.inventory.application.ports.out.UpdateInventoryOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdatedInventoryAdapter implements UpdateInventoryOutputPort {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private InventoryEntityMapper inventoryEntityMapper;

    @Override
    public void update(Inventory inventory) {
        var inventoryEntity = inventoryEntityMapper.toInventoryEntity(inventory);
        inventoryRepository.save(inventoryEntity);
    }
}
