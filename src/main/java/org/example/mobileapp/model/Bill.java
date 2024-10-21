package org.example.mobileapp.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private String status;
    private String customerName;
    private String server;

    private int corn;
    private int wood;
    private int stone;
    private int gold;

    private double priceDollar;
    private double priceVND;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

}
