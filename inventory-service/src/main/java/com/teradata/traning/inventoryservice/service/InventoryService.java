package com.teradata.traning.inventoryservice.service;

import com.teradata.traning.inventoryservice.model.Inventory;
import com.teradata.traning.inventoryservice.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

    @Autowired
    InventoryRepository inventoryRepository;

    public  boolean saveInventory(InventoryDTO inventoryDTO){
        Inventory inventoryEntity = new InventoryTransformer().tranform(inventoryDTO);
        Inventory saved = inventoryRepository.save(inventoryEntity);
        return saved!=null;
    }
    public boolean isExists(String name) {
        return false;
    }
    public static class InventoryDTO {

    }
    private class InventoryTransformer {
        public Inventory tranform(InventoryDTO inventoryDTO){
            return null;
        }
    }
}
