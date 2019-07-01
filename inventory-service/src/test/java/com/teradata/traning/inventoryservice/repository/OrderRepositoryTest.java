package com.teradata.traning.inventoryservice.repository;

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
public class OrderRepositoryTest {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    InventoryRepository inventoryRepository;

    @Test
    public void loadContext(){

    }

    @Test
    public void shouldSaveOrder(){

        Inventory inventory = Inventory.builder()
                .name("Samsung")
                .code(2)
                .description("testndroid screen, 5.3 inches")
                .build();
        inventoryRepository.save(inventory);
        Order order = Order.builder()
                .userId(2)
                .productDetail(inventory)
                .quantity(1)
                .address("Cyber City, Bangalore, India")
                .build();
        orderRepository.save(order);
        List<Order> allOrder= orderRepository.findAll();

        Assertions.assertThat(allOrder.stream().findFirst().equals(order));
    }
}