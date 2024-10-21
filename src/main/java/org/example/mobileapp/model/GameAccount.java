package org.example.mobileapp.model;

import jakarta.persistence.*;

@Entity
public class GameAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String server;
    private int corn;
    private int wood;
    private int stone;
    private int gold;
    private String name;
    private double price;
    private double tax;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    // Getters and Setters
}
