package com.teradata.training.orderservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "product_order", catalog = "teradata")
public class Order {

    @Id
    @Column(name = "id")
    Integer id;

    @Column(name = "user_id")
    String userId;

    @Embedded
    ProductDetail productDetail;

    @Column(name = "quantity")
    Integer quantity;

    @Column(name = "address")
    String address;

    @Embeddable
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ProductDetail {

        @Column(name = "code")
        Integer code;

        @Column(name = "name")
        String name;

        @Column(name = "description")
        String description;
    }
}
