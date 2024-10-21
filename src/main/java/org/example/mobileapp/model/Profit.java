package org.example.mobileapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "profit")
public class Profit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;

    private int corn;
    private int wood;
    private int stone;
    private int gold;
    private String server;
    private int day;
    private int time;
    private String status;
    private double receiveMoney;
    private double realMoney;
}
