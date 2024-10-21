package org.example.mobileapp.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;
    private String avatar;
    private String level;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;
}
