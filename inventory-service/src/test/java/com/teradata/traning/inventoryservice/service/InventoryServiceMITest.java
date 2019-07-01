package com.teradata.traning.inventoryservice.service;

import com.teradata.traning.inventoryservice.model.Inventory;
import com.teradata.traning.inventoryservice.repository.InventoryRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class)
public class InventoryServiceMITest {

    @Autowired
    InventoryService inventoryService;

    @Autowired
    InventoryRepository inventoryRepository;

    @Test
    public void loadContext(){

    }

    @Test
    public void shouldSaveInventoryDTO(){

        InventoryService.InventoryDTO inventoryDTO = InventoryService.InventoryDTO.builder()
                .name("Samsung")
                .description("Android 6.5 Inches")
                .build();
        Inventory expectedInventory = Inventory.builder()
                .name("Samsung")
                .description("Android 6.5 Inches")
                .build();
        // when
        boolean isSaved = inventoryService.saveInventory(inventoryDTO);

        // then
        List<Inventory> allByName = inventoryRepository.findAllByName("Samsung");
        Assertions.assertThat(allByName.stream().findFirst().equals(expectedInventory));

    }
}