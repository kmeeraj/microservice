package com.teradata.traning.inventoryservice.controller;

import com.teradata.traning.inventoryservice.model.Order;
import com.teradata.traning.inventoryservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderRestController {

    @Autowired
    OrderService orderService;

    @GetMapping("/allorders")
    public List<Order> AllProduct(){
        return orderService.findAll();
    }
}
