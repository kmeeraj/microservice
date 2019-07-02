package com.teradata.traning.inventoryservice.service;

import com.teradata.traning.inventoryservice.model.Inventory;
import com.teradata.traning.inventoryservice.model.Order;
import com.teradata.traning.inventoryservice.repository.InventoryRepository;
import com.teradata.traning.inventoryservice.repository.OrderRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    InventoryRepository inventoryRepository;

    public boolean saveOrder(OrderDTO orderDTO){
        Order order = new Transformer().transfomer(orderDTO);
        inventoryRepository.save(order.getProductDetail());
        Order saved = orderRepository.save(order);
        return saved!=null;
    }

    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    @EqualsAndHashCode
    public static class OrderDTO {

        Integer userId;
        InventoryService.InventoryDTO productDetail;
        Integer quantity;
        String address;
    }

    private class Transformer {
        public Order transfomer(OrderDTO orderDTO){
            Inventory inventoryEntity = new InventoryTransformer().tranform(orderDTO.getProductDetail());
            return Order.builder()
                    .userId(orderDTO.getUserId())
                    .productDetail(inventoryEntity)
                    .quantity(orderDTO.getQuantity())
                    .address(orderDTO.getAddress())
                    .build();
        }
    }
}
