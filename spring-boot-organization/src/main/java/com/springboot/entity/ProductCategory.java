package com.springboot.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "product_category")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;
}
