package com.teradata.traning.inventoryservice.service;

import com.teradata.traning.inventoryservice.model.Inventory;
import com.teradata.traning.inventoryservice.model.Order;
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
public class OrderServiceTest {


    @Autowired
    OrderService orderService;

    @Test
    public void loadContext(){


    }

    @Test
    public void shouldSaveOrderDTO(){
        InventoryService.InventoryDTO inventoryDTO = InventoryService.InventoryDTO.builder()
                .name("Samsung")
                .description("Android 6.5 Inches")
                .code(1)
                .build();

        OrderService.OrderDTO orderDTO = OrderService.OrderDTO.builder()
                .userId(2)
                .productDetail(inventoryDTO)
                .quantity(2)
                .address("Cyber perl, Bangalore, India")
                .build();
        boolean isSaved = orderService.saveOrder(orderDTO);
        Inventory expectedInventory = Inventory.builder()
                .name("Samsung")
                .description("Android 6.5 Inches")
                .code(1)
                .build();
        Order expectOrder = Order.builder()
                .userId(2)
                .productDetail(expectedInventory)
                .quantity(2)
                .address("Cyber perl, Bangalore, India")
                .build();

        List<Order> allOrders = orderService.findAll();
        Assertions.assertThat(allOrders.stream().findFirst().equals(expectOrder));
    }

}