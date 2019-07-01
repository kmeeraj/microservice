package com.teradata.traning.inventoryservice.controller;

import com.teradata.traning.inventoryservice.model.Inventory;
import com.teradata.traning.inventoryservice.service.InventoryService;
import com.teradata.traning.inventoryservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InventoryRestController {

    @Autowired
    InventoryService inventoryService;

    @Autowired
    OrderService orderService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("product")
    public boolean newProduct(InventoryService.InventoryDTO inventoryDTO){
        return inventoryService.saveInventory(inventoryDTO);
    }

    @GetMapping("/product")
    public boolean Product(@RequestParam String id){
        return inventoryService.isExists(id);
    }

    @GetMapping("/allproducts")
    public List<Inventory> AllProduct(){
        return inventoryService.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("order")
    public boolean newOrder(OrderService.OrderDTO orderDTO){
        return orderService.saveOrder(orderDTO);
    }
}
