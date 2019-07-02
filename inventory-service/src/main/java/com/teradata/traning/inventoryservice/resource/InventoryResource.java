package com.teradata.traning.inventoryservice.resource;

import com.teradata.traning.inventoryservice.model.Inventory;
import com.teradata.traning.inventoryservice.service.InventoryService;
import com.teradata.traning.inventoryservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "inventory")
public class InventoryResource {

    @Autowired
    InventoryService inventoryService;

    @PostMapping
    @RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<Boolean> createInventory(InventoryService.InventoryDTO inventoryDTO){
        boolean saved = inventoryService.saveInventory(inventoryDTO);
        if(saved){
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }else {
            throw new InventoryNoCreatedException();
        }
    }

    private class InventoryNoCreatedException extends RuntimeException {

    }

    @GetMapping
    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> isExists(@RequestParam String name) {
        boolean exists = inventoryService.isExists(name);
        return ResponseEntity.ok(exists);
    }

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
