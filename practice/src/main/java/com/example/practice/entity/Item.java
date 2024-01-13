package com.example.practice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="items")
public class Item
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, unique=true)
    private String name;

    @Column(nullable=false)
    private double price;

    @Column(nullable=false)
    private Integer quantity;

    @Column(nullable=false)
    private String description;

    @ManyToMany
    @JoinTable(name = "items_orders",joinColumns = {@JoinColumn(name="ITEM_ID",referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name="ORDER_ID",referencedColumnName = "ID")}
    )
    private List<Order> orders;
}