package com.teradata.traning.inventoryservice.service;

import com.teradata.traning.inventoryservice.model.Inventory;

public class InventoryTransformer {
    public Inventory tranform(InventoryService.InventoryDTO inventoryDTO){
        return Inventory.builder()
                .name(inventoryDTO.getName())
                .description(inventoryDTO.getDescription())
                .quantity(inventoryDTO.getQuantity())
                .build();
    }
}
