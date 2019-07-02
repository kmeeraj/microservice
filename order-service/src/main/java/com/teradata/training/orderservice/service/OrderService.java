package com.teradata.training.orderservice.service;

import com.teradata.training.orderservice.model.Order;
import com.teradata.training.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    RestTemplate restTemplate;


    public boolean createOrder(Order order) {
        //validating the order
        //all the attributes are correct.

        ResponseEntity<Boolean> forEntity = getBooleanResponseEntity(order);
        if (forEntity.getBody()) {
            Order saved = orderRepository.save(order);
            //messageProducer.sendOrderCreatedMessage(OrderCreatedEvent.builder().name("created").msg("OrderId=123").build());
            return saved != null;
        } else {
            return false;
        }
    }

    //@HystrixCommand(fallbackMethod = "createOrderFallback")
    public ResponseEntity<Boolean> getBooleanResponseEntity(Order order) {
        return restTemplate.getForEntity("http://localhost:8081/inventory?id=" + order.getProductDetail().getCode(), Boolean.class);
        // return null;
    }


    public ResponseEntity<Boolean> createOrderFallback(Order order) {
        return ResponseEntity.ok().body(true);
    }
}
