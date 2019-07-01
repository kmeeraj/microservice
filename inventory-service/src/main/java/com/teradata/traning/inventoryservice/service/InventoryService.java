package com.teradata.traning.inventoryservice.service;

import com.teradata.traning.inventoryservice.model.Inventory;
import com.teradata.traning.inventoryservice.repository.InventoryRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.Size;

@Service
public class InventoryService {

    @Autowired
    InventoryRepository inventoryRepository;

    public  boolean saveInventory(@Valid InventoryDTO inventoryDTO){
        Inventory inventoryEntity = new InventoryTransformer().tranform(inventoryDTO);
        Inventory saved = inventoryRepository.save(inventoryEntity);
        return saved!=null;
    }
    public boolean isExists(String name) {
        return false;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    @EqualsAndHashCode
    public static class InventoryDTO {
        @Size(max = 100, min = 10, message ="Please provide the name in the range of 10 to 100")
        String name;
        String description;
    }
    private class InventoryTransformer {
        public Inventory tranform(InventoryDTO inventoryDTO){
            return Inventory.builder()
                    .name(inventoryDTO.getName())
                    .description(inventoryDTO.getDescription())
                    .build();
        }
    }
}
