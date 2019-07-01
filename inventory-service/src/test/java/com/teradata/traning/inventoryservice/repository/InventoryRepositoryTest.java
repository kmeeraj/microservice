package com.teradata.traning.inventoryservice.repository;

import com.teradata.traning.inventoryservice.model.Inventory;
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
public class InventoryRepositoryTest {


    @Autowired
    InventoryRepository inventoryRepository;


    @Test
    public void loadContext(){

    }

    @Test
    public void shouldFindInventoryByName(){
        Inventory inventory = Inventory.builder()
                .name("Samsung")
                .description("testndroid screen, 5.3 inches")
                .build();
        inventoryRepository.save(inventory);
        List<Inventory> allInventory = inventoryRepository.findAllByName(inventory.getName());

        Assertions.assertThat(allInventory.stream().findFirst().equals(inventory));
    }

    @Test
    public void shouldSaveInventory(){
        Inventory inventory = Inventory.builder()
                .name("Samsung")
                .description("testndroid screen, 5.3 inches")
                .build();
        inventoryRepository.save(inventory);
        List<Inventory> allInventory = inventoryRepository.findAll();

        Assertions.assertThat(allInventory.stream().findFirst().equals(inventory));
    }
}