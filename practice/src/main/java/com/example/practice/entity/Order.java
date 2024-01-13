package com.example.practice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="orders")
public class Order
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private LocalDate createTime;

    @ManyToOne
    @JoinColumn(name = "users", referencedColumnName = "ID")
    private User user;

    @ManyToMany(mappedBy = "orders")
    private List<Item> items;
}