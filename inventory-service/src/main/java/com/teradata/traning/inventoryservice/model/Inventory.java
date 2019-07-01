package com.teradata.traning.inventoryservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "inventory", schema = "teradata")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "id")
@EqualsAndHashCode
@Data
public class Inventory {
    @Id
    @GeneratedValue
    @Column(name = "id")
    Long id;

    @Column(name = "code")
    Integer code;

    @Column(name = "quantity")
    Integer quantity;

    @Column(name = "name")
    String name;

    @Column(name = "description")
    String description;

   @OneToMany(mappedBy = "productDetail", cascade = CascadeType.ALL)
    private Set<Order> orders;
}
