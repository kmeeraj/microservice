package com.teradata.traning.inventoryservice.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "inventory", schema = "teradata")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Data
public class Inventory {
    @Id
    @GeneratedValue
    @Column(name = "id")
    Long id;

    @Column(name = "name")
    String name;

    @Column(name = "description")
    String description;
}
