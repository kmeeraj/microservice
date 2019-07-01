package com.teradata.traning.inventoryservice.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "inventory", schema = "teradata")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "id")
@EqualsAndHashCode
@Data
public class Order {
    @Id
    @GeneratedValue
    @Column(name = "id")
    Long id;

    @Column(name = "userId")
    Integer userId;

    @ManyToOne
    @JoinColumn
    Inventory productDetail;

    @Column(name = "quantity")
    Integer quantity;

    @Column(name = "address")
    String address;

}
