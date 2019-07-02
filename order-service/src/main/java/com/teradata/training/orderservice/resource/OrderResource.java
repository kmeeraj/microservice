package com.teradata.training.orderservice.resource;


import com.teradata.training.orderservice.model.Order;
import com.teradata.training.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/order")
public class OrderResource {

    @Autowired
    OrderService orderService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity createOrder(@RequestBody Order order){

        //
        if(orderService.createOrder(order)){
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }else{
            throw new OrderNotCreatedException();
        }
        //
    }

    private class OrderNotCreatedException extends RuntimeException {
    }
}


